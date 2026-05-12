# Prompt Engineering

Prompt engineering is the practice of designing inputs to AI models to get the best possible outputs.

## Core Techniques

### 1. Zero-Shot Prompting

Simply describe the task without examples.

```
Translate the following text to French:
"Hello, how are you?"
```

### 2. Few-Shot Prompting

Provide examples to guide the model.

```
Translate English to French:
English: Hello
French: Bonjour

English: Thank you
French: Merci

English: Good morning
French:
```

### 3. Chain-of-Thought (CoT)

Ask the model to reason step by step before answering.

```
Q: A store has 12 apples. It sells 4 and receives a shipment of 7 more.
How many apples does the store have now?

Let's think step by step.
```

### 4. System Prompts

Set context and behavior with a system message (for chat models).

```
You are a helpful senior software engineer who reviews code for security issues.
You always provide specific line references and explain the risk clearly.
```

### 5. Role Prompting

Give the model a persona.

```
You are an expert nutritionist. Answer the following question:
What are the best foods to eat before a workout?
```

### 6. Output Formatting

Ask for structured output.

```
List the top 5 programming languages in 2024 as a JSON array with fields:
"name", "main_use_case", "popularity_rank".
```

## Common Pitfalls

- **Too vague** — "Write something about dogs" → be specific about length, tone, format
- **Ambiguous instructions** — be explicit about what you want
- **Not specifying format** — if you need JSON, markdown, a list, say so
- **Ignoring the system prompt** — use it to set persistent context

## Advanced Techniques

### Self-Consistency
Generate multiple responses and pick the most common answer.

### ReAct (Reasoning + Acting)
Combine reasoning steps with tool use (used in agents).

### Retrieval-Augmented Generation (RAG)
Provide relevant documents in the prompt context to ground the model's answers.

## Resources

- [Prompt Engineering Guide](https://www.promptingguide.ai)
- [OpenAI Prompt Engineering Docs](https://platform.openai.com/docs/guides/prompt-engineering)
- [Learn Prompting](https://learnprompting.org)
