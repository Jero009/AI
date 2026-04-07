# Knowledge Distillation

A collection of guides and resources for distilling AI models — compressing a large model's knowledge into a smaller one.

## Contents

- [Overview](#overview)
- [Types of Distillation](#types-of-distillation)
- [Popular Frameworks](#popular-frameworks)
- [Guides](#guides)

## Overview

Knowledge distillation is a model compression technique where a small **student** model is trained to mimic the behavior of a larger **teacher** model. The goal is a smaller, faster model that retains most of the teacher's performance.

```
Teacher model (large, slow, accurate)
        ↓  teaches
Student model (small, fast, nearly as accurate)
```

## Types of Distillation

| Type | Description |
|------|-------------|
| **Response-based** | Student learns from the teacher's output (soft labels / logits) |
| **Feature-based** | Student learns from intermediate layer activations of the teacher |
| **Relation-based** | Student learns from relationships between data points in the teacher |
| **Data-free** | Distillation without access to the original training data |
| **On-policy** | Student generates data; teacher scores it (used in LLM distillation) |

## Why Distill?

- Deploy on devices with limited compute (mobile, edge)
- Reduce inference costs and latency
- Make models more efficient without retraining from scratch

## Popular Frameworks

| Tool | Description | Link |
|------|-------------|------|
| [Hugging Face Transformers](https://huggingface.co/docs/transformers) | DistilBERT and other distilled models | https://huggingface.co |
| [DistilBERT](https://huggingface.co/distilbert-base-uncased) | 40% smaller BERT with 97% of its performance | https://huggingface.co/distilbert-base-uncased |
| [TinyLlama](https://github.com/jzhang38/TinyLlama) | Small LLaMA-based model trained on large data | https://github.com/jzhang38/TinyLlama |
| [Microsoft OLIVE](https://github.com/microsoft/Olive) | Model optimization toolchain including distillation | https://github.com/microsoft/Olive |

## Guides

- [guide-distillation-basics.md](guide-distillation-basics.md) — Basic knowledge distillation with PyTorch
