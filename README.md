# 🏋️‍♂️ Make Fitness | 헬스 수업 예약 플랫폼

> 트레이너와 회원 간의 **수업 등록**, **예약**, **출결**, **결제** 과정을  
> 효율적으로 연결하는 **웹 기반 통합 헬스 관리 시스템**

---

## 🔖 목차

- [✨ 프로젝트 소개](#-프로젝트-소개)  
- [🧩 주요 기능](#-주요-기능)  
- [⚙️ 기술 스택](#-기술-스택)  
- [🧱 시스템 아키텍처](#-시스템-아키텍처)  
- [📂 프로젝트 구조](#-프로젝트-구조)  
- [🚀 실행 방법](#-실행-방법)  
- [🧪 테스트 계정](#-테스트-계정)  
- [🖼 주요 화면](#-주요-화면)  
- [🧠 구현 포인트](#-구현-포인트)  
- [📄 API 명세서 & ERD](#-api-명세서--erd)  
- [👨‍💻 개발자 정보](#-개발자-정보)  
- [🔗 관련링크](#-관련링크)  
- [💬 프로젝트 회고](#-프로젝트-회고)
---

## ✨ 프로젝트 소개

**Make Fitness**는 헬스장을 위한 맞춤형 수업 예약 시스템입니다.  
트레이너는 수업을 등록하고 회원 예약 현황을 실시간으로 확인할 수 있으며,  
회원은 자신의 이용권(프로모션) 범위 내에서 편리하게 수업을 예약하고 출석 내역을 확인할 수 있습니다.  
결제는 PortOne을 통해 연동되며, 예약 및 출결은 **캘린더 UI**와 연동되어 실시간 반영됩니다.

---

## 🧩 주요 기능

### ✅ 회원 (Customer)
- JWT 기반 로그인 및 인증
- 보유 이용권(프로모션) 목록 확인
- 캘린더 기반 수업 예약 및 조회
- 출석 완료 수업 히스토리 확인

### ✅ 트레이너 (Trainer)
- 수업 등록 (다중 시간대 선택 지원)
- 등록된 수업 조회 / 삭제
- 회원별 예약 현황 확인
- 당일 자동 출석 처리

### ✅ 결제 시스템
- PortOne 결제 연동 (KakaoPay, 카드)
- 프로모션 구매 시 예약 권한 자동 부여
- 수업 예약 시 남은 횟수 자동 차감 / 삭제 시 복구

---

### ⚙️ 기술 스택

| 구분 | 기술 |
|------|------|
| **Frontend** | React, React Router, Emotion, Axios |
| **Backend** | Spring Boot 3.4.3, Spring Security, MyBatis |
| **Database** | MySQL |
| **CI/CD** | GitHub Actions, NGINX, EC2 |
| **Auth** | JWT |
| **Payment** | PortOne Browser SDK |
| **문서화** | Swagger (SpringDoc 기반) |

---

## 🧱 시스템 아키텍처

```
[React]
   ↑
   ↓
[Spring Boot + JWT + Swagger]
   ↑
   ↓
 [MySQL]

※ 연동 서비스:
  ↑
  ↓
[PortOne SDK]

※ 배포 환경:
[GitHub Actions + EC2]
```

## 📂 프로젝트 구조
```
make-fitness/
 ┣ back/
 ┃ ┣ controller/
 ┃ ┣ service/
 ┃ ┣ repository/
 ┃ ┣ mapper/
 ┃ ┣ dto/
 ┃ ┗ entity/
 ┗ front/
   ┣ pages/
   ┣ components/
   ┣ apis/
   ┣ router/
   ┗ context/
```

## 🚀 실행 방법

### 프론트엔드 실행
```bash
npm run dev
```


### 🧪 테스트 계정

| 구분     | ID         | PW         |
|----------|------------|------------|
| Admin    | admin1234  | admin1234! |
| Manager  | park1234   | dong1234!  |
| Customer | wogus2974  | wogus2987! |

### 🖼 주요 화면
## 🔐 로그인
![Image](https://github.com/user-attachments/assets/70475d42-53c6-4f17-bc34-22bf1fa6ccb4)

> 로그인 기능

## 📝 수업 등록 (트레이너)
![Image](https://github.com/user-attachments/assets/85daedec-d894-4649-849c-edb6a39f632b)


> 트레이너는 원하는 날짜의 시간대를 선택해 수업을 등록하거나, 이미 등록된 수업은 삭제 모드로 전환해 쉽게 제거 가능하다.  

## 📅 수업 예약 (회원)

![Image](https://github.com/user-attachments/assets/e6e06194-663a-4374-84c4-1e273159844d)

> 이용자는 날짜를 선택해 예약 가능한 수업을 확인하고, 정원 초과 여부 및 예약 상태를 실시간으로 확인 후 즉시 예약/취소할 수 있다.
> 서버와 연동되어 세션 차감, 중복 방지, 정원 관리가 자동 처리된다.

## 👤 회원가입
![Image](https://github.com/user-attachments/assets/dce87668-062c-4164-a141-5d979483e5cd)

> 회원가입 기능
 
## 💳 매출 관리
![Image](https://github.com/user-attachments/assets/03214c51-4f9a-4537-adb3-1b9b7ae527db)

> 관리자는 매년 및 매달 매출을 확인하며 어떤 프로모션이 수요가 많은지 한 눈에 확인해 그에 맞는 마케팅 전략을 짤 수 있습니다.

## 회원 관리 (트레이너)
![Image](https://github.com/user-attachments/assets/8bbc8174-e1c4-46eb-be2b-c5cfb3454acc)

> 트레이너는 회원관리 페이지에서 나의 수업을 듣고 있는 모든 회원을 볼 수 있으며 남은 횟수와 종료기간을 확인하여 추가적인 마케팅을 할 수 있도록
> 설계하였습니다.

## 회원 관리 (관리자)
![Image](https://github.com/user-attachments/assets/6b9453f5-09c5-4d7c-91cd-422e860a5910)

> 관리자는 회원관리 페이지에서 회원가입한 모든 회원을 볼 수 있으며 회원구분에서 권한을 변경할 수 있도 페이지를 구현하였습니다.

## 📌 멤버십 가입
![KakaoTalk_20250416_142452041](https://github.com/user-attachments/assets/a98ab71d-2410-4dcb-86bf-2480923b706b)


> 사용자가 선택한 멤버십 상품을 결제 후, 서버에 등록하여 세션/권한까지 자동 설정이 되도록 설계하였습니다.

## 🗺️ 헬스장 위치
![Image](https://github.com/user-attachments/assets/7c6d6cdb-4e26-4a9e-9152-435459517a17)

> 카카오지도를 이용하여 위치정보를 표시해 이용자들이 알아보기쉽게 구현하였습니다.

## 🧠 구현 포인트
예약 제약 조건 설계
→ 사용자가 구매한 이용권(프로모션)의 트레이너에게만 예약 가능

자동 출석 처리
→ 당일 수업 자동 출석 체크 및 출결 히스토리 반영

예약 취소/삭제 처리
→ 수업 삭제 시 예약 자동 취소 및 횟수 복구 처리

실시간 캘린더 반영
→ 예약/삭제 시 즉시 반영되는 프론트 캘린더 로직 구현

Swagger + GitHub Actions
→ API 문서 자동화 및 배포 자동화 CI/CD 구성

## 📄 API 명세서 & ERD

### 🛰️ API 명세서 요약

| 구분     | 기능         | Method | API Path                                     | 설명                             |
|----------|--------------|--------|----------------------------------------------|----------------------------------|
| 비회원   | 로그인        | POST   | `/auth/signin`                               | 로그인 요청                      |
| 비회원   | 회원가입      | POST   | `/auth/signup`                               | 회원가입 요청                    |
| 공통     | 수업 조회     | GET    | `/makefitness/exercise`                      | PT/필라테스 수업 리스트          |
| 공통     | 위치 조회     | GET    | `/makefitness/map`                           | 헬스장 지도 위치                 |
| 공통     | 멤버십        | GET    | `/makefitness/membership`                    | 이용권 리스트                    |
| 공통     | 강사진        | GET    | `/makefitness/trainer`                       | 트레이너 리스트 조회             |
| 공통     | 리뷰 작성     | POST   | `/makefitness/review`                        | 리뷰 작성                        |
| 회원     | 수업 예약     | POST   | `/makefitness/reservations`                  | 수업 예약                        |
| 회원     | 마이페이지    | GET    | `/makefitness/mypage`                        | 회원 정보 수정/확인             |
| 매니저   | 회원관리      | GET    | `/makefitness/manager/membermanagement`      | 소속 회원 리스트                |
| 매니저   | 수업 등록     | POST   | `/makefitness/manager/classes`               | 수업 등록                        |
| 관리자   | 매출 관리     | GET    | `/makefitness/sales`                         | 관리자 매출 페이지               |
| 관리자   | 근무자 관리   | GET    | `/makefitness/worker`                        | 트레이너 관리                    |

[👉 API 명세서 ] 
![Image](https://github.com/user-attachments/assets/89843b3e-4d1c-4173-8ee7-8f9a5d5d63a9)
![Image](https://github.com/user-attachments/assets/858c7f76-0c0a-436a-b725-7560901b3662)

### 🗂️ ERD (Entity Relationship Diagram)
![Image](https://github.com/user-attachments/assets/5e376d5b-af3b-4c16-bb72-2ad11dd79b47)

- 각 테이블 간 관계와 비즈니스 흐름을 시각적으로 표현
- `user_tb`, `class_tb`, `promotion_tb`, `membership_tb`, `reservation_tb`, `pay_tb` 중심으로 구성

### 👨‍💻 프론트 / 백엔드 역할 분담 요약

#### ✅ 프론트엔드
- 캘린더 기반 수업 예약 / 삭제 / 출석 UI
- 회원별 수업 조회, 이용권 확인 기능 구현
- PortOne 연동 결제 버튼 + 모달 연동
- React Router 기반 라우팅 / 권한 처리
- Emotion 기반 UI 컴포넌트

#### ✅ 백엔드
- Spring Security + JWT 인증 체계 구축
- MyBatis 기반 쿼리 매핑 및 DTO 구조
- 수업 예약 제한 조건 / 출석 로직 구현
- 이용권 구매 → 세션 차감 / 복구 프로세스
- Swagger 문서화 + CI/CD 자동 배포 연동

---

### 👨‍💻 개발자 정보

| 이름               | 역할                     |
|--------------------|--------------------------|
| 배수빈 (BAE SUBEEN) | DB 설계 및 API 기능 구현 (백엔드) |

## 🛠 담당 범위

- DB 모델링 및 관계 설계  
- Figma를 통한 UX 흐름 구성  
- Spring Boot 기반 API 구현  
- React UI / 캘린더 컴포넌트 개발  
- CI/CD 자동화 및 배포 구성

### 🔗 관련링크
## 📄 노션 프로젝트 문서: https://lake-guanaco-5fe.notion.site/1af2ef25054380d5bdf8f184138b735e

### 💬 프로젝트 회고
이번 웹 프로젝트를 진행하면서 프론트엔드와 백엔드 간의 협업과 소통에 대해 많은 생각을 하게 된 계기가 되었습니다. 저희 조는 다른 조와 다르게 프론트엔드와 백엔드의 기능을 분담하여 프로젝트를 진행하였고, 그 중 저는 백엔드를 담당하였습니다. 기능을 구현하면서 프론트엔드와의 원활한 연동을 위해 어떤 데이터를 요청받고, 어떤 형식으로 응답해야 하는지에 대해 많은 고민을 했습니다. 이 과정에서 시스템이 어떤 흐름으로 동작하는지 충분히 이해하지 못하면 실제 서비스 단계에서 많은 어려움이 발생할 가능성이 있다는 것을 느끼게 되었습니다. 

그리고 프로젝트를 마무리 단계에서는 클린코드 작업과 코드리뷰를 동시에 진행하면서 팀원과의 소통에 대해서 다시 한번 더 중요함을 알게 되었습니다. 서로의 코드를 이해하고 부족한 부분을 서로 피드백해줄 수 있는 소중한 시간이었으며, 프로젝트 완성도를 높이는 데 큰 도움이 되었습니다.

또한, DB설계의 중요성도 깨닫게 되었습니다. 초반에 기능 중심으로 DB를 설계하다 보니, 테이블의 수도 많아지고 외래키도 과도하게 설정되면서 오히려 불필요한 컬럼도 생기거나 데이터 흐름이 복잡해지는 문제가 발생했습니다. 이 경험을 토대로 기능뿐만 아니라 데이터의 흐름과 관계를 먼저 고려한 설계의 필요성을 느꼈고, 이후에는 팀원들과 이전보다 간결한 테이블을 재설계할 수 있었습니다.

전체적으로 이번 프로젝트는 기술적인 부분 뿐만 아니라 협업과 커뮤니케이션에서도 많은 것을 배울 수 있었습니다. 앞으로 다른 프로젝트를 진행하게 된다면, 그 때는 이 경험을 기반으로 AI와 연관된 기능도 구현해보고 싶습니다.
