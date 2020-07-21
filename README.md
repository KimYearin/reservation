# reservation
reservation 웹 페이지 만들기1


<웹프론트엔드 기술요구사항>
- DOMContentloaded 이후에 모든 자바스크립트 로직이 동작하게 합니다.
- 상단영역의 애니메이션은 CSS3의 transition과 transform 속성을 활용해서 구현해야 합니다.
- TABUI로 구성되는 카테고리 아이템이 노출되는 영역의 HTML은 카테고리별로 각각 만들지 않고 하나로 만들어 재사용합니다.
- 카테고리 탭을 선택할 때마다, Ajax 요청을 해서 데이터를 가져와야 합니다.
- 탭 메뉴 (전시/뮤지컬/콘서트 등)는 Event delegation으로 구현합니다.
- Template 코드를 javascript 함수 안에 보관하지 않고, 별도 분리시켜서 사용해야 합니다. (HTML에 script태그 안에 보관한다던가)
- 함수 하나에 여러 개의 기능을 넣지 않고, 함수를 여러 개로 분리합니다.

***

<웹백엔드 기술요구사항>
- 제공된 SQL을 이용해서 테이블을 생성하고, 샘플데이터를 입력합니다.
- maven을 이용해서 웹 어플리케이션 프로젝트를 작성합니다.
- 학습했던 것처럼 controller,service,dao로 레이어드 아키텍쳐를 구성합니다.
- spring JDBC를 이용하여 주어진 테이블로부터 입력, 수정, 삭제, 조회하는 DAO와 DTO를 작성합니다.
- 서비스 인터페이스를 작성하고 해당 서비스 인터페이스에 비지니스 메소드를 작성합니다.
- 서비스 인터페이스를 구현하는 클래스를 작성합니다.
- 해당 구현 클래스의 메소드에 적절한 트랜잭션에 관련된 애노테이션을 사용합니다.
- 클라이언트에게 Web API를 제공하기 위해 RestController 를 작성합니다.

***


<main page 1 >
<img width="600" height="300" src=https://user-images.githubusercontent.com/51191647/88021272-253ccb80-cb68-11ea-9d6d-60575d16f5c6.JPG>
- 프로모션 이미지는 무한 슬라이딩으로 계속 넘어간다.  

<main page 2>
<img width="600" height="300" src=https://user-images.githubusercontent.com/51191647/88021283-2968e900-cb68-11ea-9da6-304a29a88c37.JPG>
- 전체리스트/전시/뮤지컬 등 해당섹션을 클릭하면 섹션별로 정보가 아래에 뜬다.

<main page 3>
<img width="600" height="300" src=https://user-images.githubusercontent.com/51191647/88021291-2bcb4300-cb68-11ea-8b53-e218ed073435.JPG>
- 더보기 버튼을 누르면 4개씩 정보가 추가된다.

<데이터 UML>
<img width="600" height="300" src=https://user-images.githubusercontent.com/51191647/88021296-2cfc7000-cb68-11ea-9479-aeb700d13f30.JPG>
