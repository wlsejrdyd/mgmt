# ⚙️ MGMT - 통합 관리 시스템

> 서비스 운영을 위한 통합 관리 플랫폼

[![Deploy](https://github.com/wlsejrdyd/mgmt/actions/workflows/deploy.yml/badge.svg)](https://github.com/wlsejrdyd/mgmt/actions/workflows/deploy.yml)

## 🌐 Live

- **관리자**: https://mgmt.deok.kr

---

## ✨ 주요 기능

### 📊 대시보드
- 서비스 현황 모니터링

### 👥 사용자 관리
- 회원 목록 조회/관리
- 권한 관리

### 📝 컨텐츠 관리
- 게시물/영상 관리
- 신고 처리

### 🔧 시스템 설정
- 서비스 설정 관리
- 공지사항 관리

---

## 🛠️ Tech Stack

| 영역 | 기술 |
|------|------|
| **Backend** | Spring Boot 3.x, Spring Security, JPA |
| **Database** | MariaDB |
| **Frontend** | Thymeleaf, Vanilla JS |
| **Server** | Nginx (리버스 프록시) |
| **Infra** | Rocky Linux 9, Systemd |
| **CI/CD** | GitHub Actions |
| **Monitoring** | Prometheus + Grafana ([infra.deok.kr](https://infra.deok.kr)) |

---

## 📁 프로젝트 구조

```
mgmt/
├── src/main/java/kr/deok/mgmt/
│   ├── config/          # Security, Web 설정
│   ├── controller/      # API & Web 컨트롤러
│   ├── domain/          # Entity
│   ├── dto/             # Request/Response DTO
│   ├── repository/      # JPA Repository
│   └── service/         # 비즈니스 로직
├── src/main/resources/
│   ├── static/          # CSS, JS
│   ├── templates/       # Thymeleaf 템플릿
│   └── application.yml  # 설정
└── .github/workflows/   # CI/CD
```

---

## 🚀 배포

### 자동 배포 (GitHub Actions)
`main` 브랜치 push 시 자동 배포:
1. 배포 전 자동 백업
2. Git pull + Gradle build
3. 서비스 재시작
4. 헬스체크 (실패 시 자동 롤백)

### 수동 배포
```bash
cd /app/mgmt/mgmt
git pull origin main
./gradlew build -x test
sudo systemctl restart mgmt
```

---

## 👤 Author

- GitHub: [@wlsejrdyd](https://github.com/wlsejrdyd)
- Email: wlsejrdyd@gmail.com
