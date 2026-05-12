# Running AI Models Locally

A collection of guides and resources for running AI models on your own hardware.

## Contents

- [Requirements](#requirements)
- [Popular Tools](#popular-tools)
- [Model Sources](#model-sources)
- [Guides](#guides)

## Requirements

Before running AI models locally, make sure you have:

- Sufficient RAM (minimum 8 GB, recommended 16 GB+)
- GPU (optional but recommended for faster inference)
- Python 3.8+ or another supported runtime
- Enough disk space for model weights

## Popular Tools

| Tool | Description | Link |
|------|-------------|------|
| [Ollama](https://ollama.com) | Run large language models locally with a simple CLI | https://ollama.com |
| [LM Studio](https://lmstudio.ai) | Desktop app to run local LLMs | https://lmstudio.ai |
| [llama.cpp](https://github.com/ggerganov/llama.cpp) | C++ inference engine for LLaMA-based models | https://github.com/ggerganov/llama.cpp |
| [GPT4All](https://gpt4all.io) | Open-source assistant-style large language models | https://gpt4all.io |
| [text-generation-webui](https://github.com/oobabooga/text-generation-webui) | A gradio web UI for running LLMs | https://github.com/oobabooga/text-generation-webui |

## Model Sources

- [Hugging Face](https://huggingface.co/models) — Large repository of pretrained models
- [TheBloke on HF](https://huggingface.co/TheBloke) — Quantized GGUF/GPTQ models ready for local use
- [Ollama Library](https://ollama.com/library) — Curated models for Ollama

## Guides

- [guide-ollama.md](guide-ollama.md) — Step-by-step guide for Ollama
- [guide-llamacpp.md](guide-llamacpp.md) — Step-by-step guide for llama.cpp
