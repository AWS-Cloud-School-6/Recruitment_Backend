# Recruitment_Backend
AWS Cloud School 6기 3팀 미니 프로젝트 recruitment 사이트 Backend 팀 입니다.
대규모 트래픽 발생시 어떠한 Architecutre 를 구성해야 보다 원활한 Service 가 될지 고민하다 설정하게된 프로젝트 입니다.
K8S 환경으로 Service 를 배포했고 Front 는 React , Back 은 SpringBoot , DB 는 Cloud SQL 으로 Mysql 을 사용했습니다.


----


- [Architecture](#Architecture)
   - [3 Tier Architecture](#3-Tier-Architecutre)
   - [+ HPA](#+HPA)
   - [+ Messeage Queue](#+Messeage-Queue)
   - [Architecture Test](#최종-비교)
- [배운점 + 해결한점](#Test)
   - [기존 문제](#문제발생)
   - [임시 해결](#임시해결)
   - [최종 해결](#최종해결)

----


# Architecture

간단한 3-Tier , HPA , RabbitMQ 순으로 3가지의 Architecture 로 나누어서 설계를 하였습니다.

## 3-Tier-Architecutre

<img width="1173" alt="스크린샷 2024-08-23 오후 1 47 22" src="https://github.com/user-attachments/assets/f58ef3f2-d059-469e-bcc7-08dbc238ed22">

### 3 Tier Architecture Test

#### GET
<img width="1036" alt="스크린샷 2024-08-23 오후 1 49 24" src="https://github.com/user-attachments/assets/05b870ae-86da-4108-aee3-a87465c1dd05">

#### POST
<img width="1017" alt="스크린샷 2024-08-23 오후 1 55 13" src="https://github.com/user-attachments/assets/3daa62fe-9567-43f4-b99f-6c6022c3ee7a">


Front,Back 각각 한개의 POD 만 작성해서 Test 한 결과 입니다.

## +HPA

<img width="1179" alt="스크린샷 2024-08-23 오후 1 51 43" src="https://github.com/user-attachments/assets/df9a03cf-e92a-43f8-bc0a-82bf3fa373cc">

한개의 POD 만 사용했던것을 넘어서 내부에 HPA 를 적용했습니다. Cloud 내에서도 Traffic Metric 을 두어서 Auto Scaling 을 하는것과 같이 HPA 도 같은 기능을 합니다.

### + HPA Test

#### GET

이 부분에서 GET 은 처리량이 1번과 비교해서 상당하게 증가했다는것을 알수 있음.

<img width="1038" alt="스크린샷 2024-08-23 오후 1 55 38" src="https://github.com/user-attachments/assets/9df03ebe-b938-4760-9f86-ffe04e7f8ee8">

#### POST

<img width="1032" alt="스크린샷 2024-08-23 오후 1 55 59" src="https://github.com/user-attachments/assets/e86547bb-7926-410f-ae73-adf7668c7fe9">


## +Messeage-Queue

<img width="1208" alt="스크린샷 2024-08-23 오후 1 54 36" src="https://github.com/user-attachments/assets/5ca924b3-2e20-46c7-93a6-15f705391816">

### + Message Queue Test

#### POST

<img width="1027" alt="스크린샷 2024-08-23 오후 1 57 13" src="https://github.com/user-attachments/assets/fa2830bf-4842-4227-893f-ab49097a82f8">

## 최종-비교

<img width="1072" alt="스크린샷 2024-08-23 오후 1 57 39" src="https://github.com/user-attachments/assets/e6f5e707-5bcf-46e5-aa97-9694945c53bb">

1번에서 2번으로 Architecutre 를 변경하면서 GET 에 대한 TEST 의 처리량은 상당하게 증가했지만 POST 에 대한 처리량은 감소하기 시작합니다. 2번에서 3번으로 POST 처리량은 증가하긴 하였지만 1번에서 3번과 비교하면 1번이 더 우수한것을 확인할수 있다.

우리가 생각한 결과는 1번에서 3번으로 가면서 GET,POST 처리량이 더욱더 증가할것을 예상했지만 그렇지 못한것은 우리 모두가 가져야할 책임입니다.


# Test

## 문제발생

## 임시해결

## 최종해결


