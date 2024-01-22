build musician image

```bash
docker build -t dai/musician -f docker\image-musician\dockerfile .
```

run image

```bash
docker run -d dai/musician INSTRUMENT
```

run container

```bash
$ docker run -d -p 2205:2205 dai/musician INSTRUMENT
```