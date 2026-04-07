# Running AI Locally with llama.cpp

[llama.cpp](https://github.com/ggerganov/llama.cpp) is a high-performance C++ inference engine for running LLaMA-based models.

## Prerequisites

- Git
- C++ compiler (GCC / Clang / MSVC)
- CMake (optional, recommended)

## Installation

```bash
git clone https://github.com/ggerganov/llama.cpp
cd llama.cpp
make
```

### With GPU support (CUDA)
```bash
make LLAMA_CUDA=1
```

### With GPU support (Metal — Apple Silicon)
```bash
make LLAMA_METAL=1
```

## Downloading a Model

Download a GGUF model from Hugging Face, for example:

```bash
# Example: Mistral 7B Q4_K_M quantization
wget https://huggingface.co/TheBloke/Mistral-7B-v0.1-GGUF/resolve/main/mistral-7b-v0.1.Q4_K_M.gguf
```

## Running Inference

```bash
./llama-cli -m mistral-7b-v0.1.Q4_K_M.gguf -p "Hello, how are you?" -n 128
```

### Common Flags

| Flag | Description |
|------|-------------|
| `-m` | Path to model file |
| `-p` | Prompt text |
| `-n` | Number of tokens to generate |
| `--ctx-size` | Context window size (default: 512) |
| `--temp` | Temperature for sampling (default: 0.8) |
| `--gpu-layers` | Number of layers to offload to GPU |

## Interactive Mode

```bash
./llama-cli -m mistral-7b-v0.1.Q4_K_M.gguf -i
```

## Notes

- GGUF is the recommended model format (replaces older GGML)
- Lower quantization (e.g. Q2) = smaller file & faster, but lower quality
- Higher quantization (e.g. Q8) = larger file & slower, but higher quality
