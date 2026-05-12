# Dataset Preparation for Training

Good training data is one of the most important factors in the quality of a fine-tuned model.

## Dataset Formats

### Instruction Format (most common for chat/instruction models)

```json
[
  {
    "instruction": "Translate the following sentence to Spanish.",
    "input": "The weather is nice today.",
    "output": "El tiempo está agradable hoy."
  }
]
```

### Conversation Format (for multi-turn chat models)

```json
[
  {
    "conversations": [
      {"role": "user", "content": "What is the capital of France?"},
      {"role": "assistant", "content": "The capital of France is Paris."}
    ]
  }
]
```

### Plain Text Format (for pretraining or continued pretraining)

```
This is a paragraph of text used for pretraining.
The model learns language patterns from this data.
```

## Data Sources

- [Hugging Face Datasets](https://huggingface.co/datasets) — thousands of ready-to-use datasets
- [OpenHermes](https://huggingface.co/datasets/teknium/OpenHermes-2.5) — high quality instruction dataset
- [Alpaca](https://github.com/tatsu-lab/stanford_alpaca) — 52K instruction-following examples
- [ShareGPT](https://huggingface.co/datasets/anon8231489123/ShareGPT_Vicuna_unfiltered) — real ChatGPT conversations

## Data Quality Tips

- Remove duplicates
- Filter out low-quality or toxic examples
- Balance classes/topics if possible
- Keep a held-out validation set (~10%)
- Aim for diversity in your examples

## Loading and Preprocessing with Hugging Face

```python
from datasets import load_dataset

# Load a dataset from Hugging Face Hub
dataset = load_dataset("tatsu-lab/alpaca", split="train")

# Inspect the dataset
print(dataset[0])

# Filter examples
dataset = dataset.filter(lambda x: len(x["output"]) > 10)

# Map a formatting function
def format_example(example):
    return {"text": f"### Instruction:\n{example['instruction']}\n\n### Response:\n{example['output']}"}

dataset = dataset.map(format_example)

# Save locally
dataset.save_to_disk("./my-dataset")
```

## Splitting Data

```python
split = dataset.train_test_split(test_size=0.1)
train_dataset = split["train"]
eval_dataset = split["test"]
```
