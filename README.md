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




 <p>main page 1<br>
 - 프로모션 이미지는 무한 슬라이딩으로 계속 넘어간다.  </p>
<img width="600" height="300" src=https://user-images.githubusercontent.com/51191647/88021272-253ccb80-cb68-11ea-9d6d-60575d16f5c6.JPG>
<br>




 <p>main page 2<br>
  - 전체리스트/전시/뮤지컬 등 해당섹션을 클릭하면 섹션별로 정보가 아래에 뜬다.</p>
<img width="600" height="300" src=https://user-images.githubusercontent.com/51191647/88021283-2968e900-cb68-11ea-9da6-304a29a88c37.JPG>
<br>



 <p>main page 3<br>
  - 더보기 버튼을 누르면 4개씩 정보가 추가된다.</p>
<img width="600" height="300" src=https://user-images.githubusercontent.com/51191647/88021291-2bcb4300-cb68-11ea-8b53-e218ed073435.JPG>
<br>


<p>데이터 UML</p>
<img width="600" height="600" src=https://user-images.githubusercontent.com/51191647/88021296-2cfc7000-cb68-11ea-9479-aeb700d13f30.JPG>
<br>


***
<백엔드 구조>
- config
  - ApplicationConfig  <br>
                        @Configuration <br>
                        @ComponentScan(basePackages = {"kr.or.connect.reservation.dao", "kr.or.connect.reservation.service"}) <br>
                        @Import({DBConfig.class})
  - DBConfig : JDBC Driver를 이용해서 MySQL접근, username과 password이용
  - WebMvcContextConfiguration : 처음 보여주는 페이지 설정
  
- controller
  - ReservationApiController : WEB API 구현
  
     a. /api/products 상품 목록 구하기 (get) <br>
     ![상품API1](https://user-images.githubusercontent.com/51191647/88024933-81a2e980-cb6e-11ea-87b8-47a25ba2bf1d.JPG)
     
     b. /api/products/{displayInfoId} 상품 전시 정보 구하기 (get) <br>
     ![상품API2](https://user-images.githubusercontent.com/51191647/88024937-836cad00-cb6e-11ea-9039-f082fa588911.JPG)
     
     c. /api/categories 카테고리 목록 구하기 (get) <br>
     ![categoryAPI](https://user-images.githubusercontent.com/51191647/88024947-86679d80-cb6e-11ea-8385-a2473eb732c0.JPG)
     
     d. /api/promotions 프로모션 목록 구하기 (get) <br>
     ![promotionAPI](https://user-images.githubusercontent.com/51191647/88024944-85367080-cb6e-11ea-8ad7-718e97aeb96f.JPG)
     
     
  - ReservationController
   - @Autowired <br>
	    ReservationService reservationService;
   - @GetMapping(path="/")
    : url주소가 "/" 일때 기본적인 정보(프로모션 정보, 카테고리별 정보)를 mainpage로 전송한다.
   - @RequestMapping(path="/getMoreContents", method = RequestMethod.POST)
    : ajax로 전체리스트 정보 요청에 대한 응답
   - @RequestMapping(path="/getMoreContents2", method = RequestMethod.POST)
    : ajax로 카테고리별 정보 요청에 대한 응답
    
    
- dao
 - ProductDao 
  1. 전체갯수 구하기
  2. 카테고리별 개수 구하기
  3. promotion갯수 구하기
  4. id값 받아서 file_info 삭제(delete_flag 변경)
  5. file_info 삽입
  6. file_info update
  7. file_info 객체 select
  8. display_info 객체 받기
  9. display_info 업데이트
  10. product_price 객체 받기
  11. product_price업데이트
  12. category id, name별 정보 select

 - ProductDaoSqls
 
 - PromotionDao
  1. 프로모션 리스트 가져오기
  2. 카테고리별 추가리스트 가져오기
  3. 전체리스트 추가리스트 가져오기
  
 - PromotionDaoSqls
 
- dto
 - category
 - Display_info_image
 - Display_info
 - File_info
 - FrontForm
 - Product_image
 - Product_price
 - Product
 - Promotion
 
- service 계층
 - public static final Integer LIMIT = 4;
	- category별 front정보 가져오기
	- category별 개수
	- caegory id, name 가져오기
	- 전체 정보 가져오기
	- file_info 삭제하기(실제로 삭제하지는 않고 flag만 바꿔줌)
	- file_info 삽입
	- file_info 업데이트
	- file_info 객체 한개 가져오기
	- display_info 객체 한개 가져오기
	- display_info 업데이트
	- product_price 객체 한개 가져오기
	- product_price 업데이트
	- promotion정보 가져오기
	- 전체갯수
	- 프로모션갯수
	 
***
<프론트앤드 구조> (mainpage.jsp)
- html템플릿을 적용해서 표현
- jstl, el표기법 이용
- ajax를 이용해서 더보기 버튼을 누르면 추가정보 가져오기
- top버튼을 누르면 페이지의 위쪽으로 이동
- 무한슬라이딩 구현

***
느낀점
1. 처음에는 할 수 있을까 걱정이 많이 됐는데 차근차근 해나가다보니 완성되서 뿌듯하다.
2. MVC패턴을 이용해서 웹을 구현하면서 MVC패턴을 익힐 수 있었다.
3. 무한슬라이딩이 자바스크립트만으로 구현할 수 있다는 것이 신기했다.
4. ajax 비동시통신을 이용해서 더보기기능을 구현하여 보람찼다.


