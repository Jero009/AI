# Training AI Models

A collection of guides and resources for training your own AI models.

## Contents

- [Overview](#overview)
- [Types of Training](#types-of-training)
- [Popular Frameworks](#popular-frameworks)
- [Hardware Requirements](#hardware-requirements)
- [Guides](#guides)

## Overview

Training an AI model means teaching it to perform a task by exposing it to data and adjusting its internal weights based on feedback (loss). There are several levels of training, from training a small model from scratch to fine-tuning a large pretrained model.

## Types of Training

| Type | Description |
|------|-------------|
| **Pretraining** | Training a model from scratch on a large corpus |
| **Fine-tuning** | Adapting a pretrained model to a specific task or domain |
| **LoRA / QLoRA** | Parameter-efficient fine-tuning using low-rank adapters |
| **RLHF** | Reinforcement Learning from Human Feedback |
| **Instruction tuning** | Fine-tuning on (prompt, response) pairs to follow instructions |

## Popular Frameworks

| Framework | Description | Link |
|-----------|-------------|------|
| [PyTorch](https://pytorch.org) | The most popular deep learning framework | https://pytorch.org |
| [Hugging Face Transformers](https://huggingface.co/docs/transformers) | High-level API for working with transformer models | https://huggingface.co/docs/transformers |
| [Axolotl](https://github.com/OpenAccess-AI-Collective/axolotl) | Streamlined fine-tuning tool | https://github.com/OpenAccess-AI-Collective/axolotl |
| [LLaMA-Factory](https://github.com/hiyouga/LLaMA-Factory) | Easy fine-tuning of LLaMA-style models | https://github.com/hiyouga/LLaMA-Factory |
| [Unsloth](https://github.com/unslothai/unsloth) | Fast and memory-efficient fine-tuning | https://github.com/unslothai/unsloth |

## Hardware Requirements

| Task | Minimum VRAM |
|------|-------------|
| Fine-tune 7B (QLoRA) | ~8 GB |
| Fine-tune 7B (LoRA fp16) | ~16 GB |
| Fine-tune 13B (QLoRA) | ~12 GB |
| Full fine-tune 7B | ~40 GB |
| Pretrain from scratch | Multiple GPUs recommended |

## Guides

- [guide-finetuning-lora.md](guide-finetuning-lora.md) — Fine-tuning with LoRA / QLoRA
- [guide-dataset-preparation.md](guide-dataset-preparation.md) — Preparing datasets for training
