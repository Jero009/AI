# Knowledge Distillation Basics with PyTorch

This guide shows how to implement basic knowledge distillation where a student model learns from a teacher model's soft output probabilities.

## Concept

In standard training, models learn from hard labels (e.g., class 0 or class 1). In distillation, the student also learns from the **soft labels** (probability distributions) produced by the teacher. These soft labels carry more information than hard labels.

The distillation loss combines:
- **Hard loss**: cross-entropy with true labels
- **Soft loss**: KL divergence between student and teacher distributions (at a higher temperature)

```
Total Loss = α * Hard Loss + (1 - α) * Soft Loss
```

## Requirements

```bash
pip install torch torchvision
```

## Example: Distillation with PyTorch

```python
import torch
import torch.nn as nn
import torch.nn.functional as F

def distillation_loss(student_logits, teacher_logits, true_labels,
                      temperature=4.0, alpha=0.5):
    """
    Compute knowledge distillation loss.

    Args:
        student_logits: raw outputs from the student model
        teacher_logits: raw outputs from the teacher model
        true_labels: ground truth class labels
        temperature: softens the probability distributions (higher = softer)
        alpha: weight for the hard loss (1 - alpha = weight for soft loss)
    """
    # Soft loss (KL divergence between student and teacher)
    soft_student = F.log_softmax(student_logits / temperature, dim=1)
    soft_teacher = F.softmax(teacher_logits / temperature, dim=1)
    soft_loss = F.kl_div(soft_student, soft_teacher, reduction="batchmean") * (temperature ** 2)

    # Hard loss (standard cross-entropy with true labels)
    hard_loss = F.cross_entropy(student_logits, true_labels)

    return alpha * hard_loss + (1 - alpha) * soft_loss


# Training loop skeleton
def train_step(student, teacher, optimizer, data, labels):
    student.train()
    teacher.eval()

    optimizer.zero_grad()

    with torch.no_grad():
        teacher_logits = teacher(data)

    student_logits = student(data)

    loss = distillation_loss(student_logits, teacher_logits, labels)
    loss.backward()
    optimizer.step()

    return loss.item()
```

## LLM Distillation via Synthetic Data

For large language models, distillation often works by:

1. Using the teacher LLM to generate high-quality outputs for a set of prompts
2. Fine-tuning the student LLM on these (prompt, output) pairs

```python
# Pseudocode: generate teacher outputs and fine-tune student
prompts = load_prompts("prompts.txt")
teacher_outputs = [teacher_model.generate(p) for p in prompts]
dataset = [{"input": p, "output": o} for p, o in zip(prompts, teacher_outputs)]
fine_tune_student(student_model, dataset)
```

This approach is used by models like **Alpaca** (distilled from GPT-4) and **Orca**.

## Tips

- Use a temperature of 3–7 for the soft loss; experiment to find the best value
- A smaller `alpha` (e.g., 0.1) gives more weight to mimicking the teacher
- The student should be architecturally similar enough to the teacher to learn effectively
- More data from the teacher generally produces better results

## Pre-Distilled Models to Use Directly

| Model | Teacher | Size reduction |
|-------|---------|---------------|
| [DistilBERT](https://huggingface.co/distilbert-base-uncased) | BERT-base | 40% smaller |
| [DistilGPT-2](https://huggingface.co/distilgpt2) | GPT-2 | 33% smaller |
| [TinyLlama-1.1B](https://huggingface.co/TinyLlama/TinyLlama-1.1B-Chat-v1.0) | LLaMA-2 | ~6x smaller |
