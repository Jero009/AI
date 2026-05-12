# Fine-Tuning with LoRA / QLoRA

LoRA (Low-Rank Adaptation) and QLoRA (Quantized LoRA) let you fine-tune large language models using a fraction of the memory normally required.

## Concept

Instead of updating all model weights, LoRA injects small trainable matrices into specific layers. Only these adapters are trained, while the base model weights stay frozen.

QLoRA combines LoRA with 4-bit quantization of the base model, allowing fine-tuning of large models on consumer GPUs.

## Requirements

```bash
pip install transformers datasets peft accelerate bitsandbytes trl
```

## Example: QLoRA Fine-Tuning with Hugging Face

```python
from transformers import AutoModelForCausalLM, AutoTokenizer, BitsAndBytesConfig
from peft import LoraConfig, get_peft_model
from trl import SFTTrainer
from datasets import load_dataset
import torch

# 4-bit quantization config
bnb_config = BitsAndBytesConfig(
    load_in_4bit=True,
    bnb_4bit_quant_type="nf4",
    bnb_4bit_compute_dtype=torch.float16,
)

# Load base model
model = AutoModelForCausalLM.from_pretrained(
    "mistralai/Mistral-7B-v0.1",
    quantization_config=bnb_config,
    device_map="auto",
)
tokenizer = AutoTokenizer.from_pretrained("mistralai/Mistral-7B-v0.1")

# LoRA config
lora_config = LoraConfig(
    r=16,
    lora_alpha=32,
    target_modules=["q_proj", "v_proj"],
    lora_dropout=0.05,
    bias="none",
    task_type="CAUSAL_LM",
)
model = get_peft_model(model, lora_config)

# Load dataset
dataset = load_dataset("your-dataset-name", split="train")

# Train
trainer = SFTTrainer(
    model=model,
    train_dataset=dataset,
    dataset_text_field="text",
    max_seq_length=512,
)
trainer.train()

# Save adapter
model.save_pretrained("./my-lora-adapter")
```

## Merging the Adapter with the Base Model

```python
from peft import PeftModel
from transformers import AutoModelForCausalLM

base_model = AutoModelForCausalLM.from_pretrained("mistralai/Mistral-7B-v0.1")
model = PeftModel.from_pretrained(base_model, "./my-lora-adapter")
merged = model.merge_and_unload()
merged.save_pretrained("./my-merged-model")
```

## Tips

- Start with a small dataset (~1000 examples) to verify the pipeline works
- Monitor training loss to detect overfitting
- Use `r=8` or `r=16` for a good balance between performance and memory
- Increase `lora_alpha` for stronger fine-tuning effect
