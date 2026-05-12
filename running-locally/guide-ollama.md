# Running AI Locally with Ollama

[Ollama](https://ollama.com) is the easiest way to run large language models locally.

## Installation

### Linux / macOS
```bash
curl -fsSL https://ollama.com/install.sh | sh
```

### Windows
Download the installer from https://ollama.com/download/windows

---

## Running a Model

```bash
# Pull and run a model (e.g. Llama 3)
ollama run llama3

# Run Mistral
ollama run mistral

# Run a smaller model (good for low-RAM machines)
ollama run phi3
```

## Listing Available Models

```bash
ollama list
```

## Pulling a Model Without Running It

```bash
ollama pull llama3
```

## Removing a Model

```bash
ollama rm llama3
```

## Using the REST API

Ollama exposes a local REST API on `http://localhost:11434`.

```bash
curl http://localhost:11434/api/generate -d '{
  "model": "llama3",
  "prompt": "Why is the sky blue?",
  "stream": false
}'
```

## Notes

- Models are stored in `~/.ollama/models`
- GPU acceleration is used automatically if a compatible GPU is detected
