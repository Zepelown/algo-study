# Algorithm Study

각자 선택한 알고리즘 문제를 풀고 PR로 풀이 과정과 코드를 공유하는 스터디 저장소입니다.

## Directory Structure

```text
.
├─ .github/
│  └─ pull_request_template.md
├─ docs/
│  └─ rules.md
└─ members/
   └─ {name}/
      └─ {platform}/
         └─ {problem-id}.{ext}
```

예시:

```text
members/yoon/boj/1000.py
members/yoon/programmers/42840.js
members/yoon/leetcode/1.java
```

## Workflow

1. 본인 이름으로 브랜치를 생성합니다.
2. `members/{name}/{platform}/` 아래에 풀이 파일을 추가합니다.
3. PR을 생성하고 템플릿에 풀이 방식, 복잡도, 걸린 시간을 작성합니다.
4. 리뷰를 받은 뒤 `main`에 머지합니다.

## Naming

- 브랜치: `solve/{name}/{platform}-{problem-id}`
- PR 제목: `[플랫폼 문제번호] 문제 이름 - 이름`
- 파일명: `{problem-id}.{ext}`

예시:

```text
solve/yoon/boj-1000
[BOJ 1000] A+B - yoon
members/yoon/boj/1000.py
```

자세한 운영 규칙은 [docs/rules.md](docs/rules.md)를 참고하세요.
