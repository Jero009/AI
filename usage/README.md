# Using AI Models

A collection of guides and resources for using AI models effectively.

## Contents

- [Overview](#overview)
- [Inference Methods](#inference-methods)
- [Prompt Engineering](#prompt-engineering)
- [Popular APIs](#popular-apis)
- [Guides](#guides)

## Overview

Using an AI model means providing it with input (a prompt) and getting output (a response or prediction). This section covers how to interact with AI models — whether running locally, via API, or through a UI.

## Inference Methods

| Method | Description |
|--------|-------------|
| **Local inference** | Run the model on your own hardware (see [running-locally](../running-locally/README.md)) |
| **API** | Call a hosted model via HTTP (OpenAI, Anthropic, Mistral, etc.) |
| **UI tools** | Use a web or desktop interface (ChatGPT, Claude, LM Studio, etc.) |
| **Python SDK** | Use an official or community library to call models programmatically |

## Prompt Engineering

Good prompts lead to better outputs. Key principles:

- **Be specific** — Give the model enough context and clear instructions
- **Provide examples** — Few-shot prompting helps the model understand the format
- **Set the role** — Use a system prompt to define the model's persona or task
- **Iterate** — Refine your prompt based on the model's responses

## Popular APIs

| Provider | Description | Docs |
|----------|-------------|------|
| [OpenAI](https://platform.openai.com) | GPT-4, GPT-3.5 | https://platform.openai.com/docs |
| [Anthropic](https://www.anthropic.com) | Claude models | https://docs.anthropic.com |
| [Mistral AI](https://mistral.ai) | Mistral models | https://docs.mistral.ai |
| [Groq](https://groq.com) | Fast inference API | https://console.groq.com/docs |
| [Together AI](https://www.together.ai) | Open-source model hosting | https://docs.together.ai |
| [Ollama](https://ollama.com) | Local REST API | https://github.com/ollama/ollama/blob/main/docs/api.md |

## Guides

- [guide-openai-api.md](guide-openai-api.md) — Using the OpenAI Python SDK
- [guide-prompt-engineering.md](guide-prompt-engineering.md) — Prompt engineering techniques
