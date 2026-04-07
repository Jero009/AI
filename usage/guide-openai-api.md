# Using the OpenAI API

The OpenAI API gives you access to GPT-4 and other models via HTTP or a Python SDK.

## Installation

```bash
pip install openai
```

## Authentication

Set your API key as an environment variable:

```bash
export OPENAI_API_KEY="sk-..."
```

## Basic Chat Completion

```python
from openai import OpenAI

client = OpenAI()

response = client.chat.completions.create(
    model="gpt-4o",
    messages=[
        {"role": "system", "content": "You are a helpful assistant."},
        {"role": "user", "content": "What is the capital of France?"}
    ]
)

print(response.choices[0].message.content)
```

## Streaming Responses

```python
stream = client.chat.completions.create(
    model="gpt-4o",
    messages=[{"role": "user", "content": "Tell me a short story."}],
    stream=True,
)

for chunk in stream:
    if chunk.choices[0].delta.content is not None:
        print(chunk.choices[0].delta.content, end="", flush=True)
```

## Using a Local Ollama Model (OpenAI-compatible)

```python
from openai import OpenAI

client = OpenAI(
    base_url="http://localhost:11434/v1",
    api_key="ollama",  # required but ignored
)

response = client.chat.completions.create(
    model="llama3",
    messages=[{"role": "user", "content": "Hello!"}]
)
print(response.choices[0].message.content)
```

## Common Parameters

| Parameter | Description | Default |
|-----------|-------------|---------|
| `model` | Model ID to use | — |
| `temperature` | Randomness (0 = deterministic, 2 = very random) | 1.0 |
| `max_tokens` | Maximum tokens in the response | model limit |
| `top_p` | Nucleus sampling threshold | 1.0 |
| `stream` | Whether to stream the response | false |
