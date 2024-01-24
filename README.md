# build musician image

```bash
docker build -t dai/musician -f docker\image-musician\dockerfile .
```

run image

```bash
docker run -d dai/musician INSTRUMENT
```

build auditor image

```bash
docker build -t dai/auditor -f docker\image-auditor\dockerfile .
```

run image

```bash
docker run -d -p 2206:2206 dai/auditor
```
# run container

```bash
$ docker run -d -p 2205:2205 dai/musician INSTRUMENT
```