build musician image

```bash
docker build -t dai/musician -f docker\image-musician\dockerfile .
```

run image

```bash
docker run -d dai/musician piano
```