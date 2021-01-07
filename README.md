# 쇼핑몰 상품 관리  - 정두영

###  

### Project Tree 

```
  main
    ├── java
    │    ├── com.megait.shoppingmall
    │    │			├── config
    |	 |			|	└── MallConfig.java
    │    │			├── controller
    |	 |			|	├── ProductRepository.java
    |	 |			|	└── ProductRepositoryImpl.java
    │    │			├── entity
    |	 |			|	└── Product.java
    │    │			├── repository
    |	 |			|	└── MallConfig.java
    │    │			└── service
    |    |				└── ProductService.java
    │    │
    │    └── ShoppingmallApplication.java
    │       
    │       
    ├── resources
         ├── static      
         └── templates.view
             		├── product-home.html
               		├── product-list.html
               		├── product-payment.html
               		└── product-register.html
 
```



- ~~`product-list.html `~~ : 상품 조회를 위한 페이지
    - ToDo
        - [x] ~~`list` : 모든 상품 정보를 조회해 `product-list.html`에게 넘겨줌~~
        - [x] ~~상품 테이블을 조회해 상품들을 조회~~
        - [x] ~~`cart.do` : 장바구니 담기 버튼 (쿠키 사용)~~
    - Optional
      - [ ] 품절 표시
      - [ ] 바로 구매하기 버튼

- `product-register.html` : 상품 등록을 위한 페이지

  - ToDo

    - [ ] 상품 정보를 입력한 후(Form) submit을 누르면 상품의 정보를 상품 테이블에 저장
    - [ ] `registerProduct.do` : 상품 정보를 테이블에 저장하는 로직

    - [ ] `registerProduct.do` : 상품 정보 저장

- ~~`product-payment.html`~~ : 장바구니에 담아 놓은 상품 ~~혹은 단일 상품~~을 구매하는 페이지

  - ToDo
    - [x] ~~`payment` : `product-payment.html` 에게 현재 장바구니(쿠키) 정보들을 넘겨줌~~
    - [x] ~~장바구니 정보(쿠키)를 불러와 페이지에 띄움~~
    - [x] ~~결제하기 버튼 : `buyProduct.do`~~ 
  - Optional
    - [ ] ***현재 로그인한 회원정보 (박기선님)*** 와 잔액(포인트(?))을 표시함 

- `buyProduct.do`
  
  - ToDo
    
    - [ ] 회원정보(박기선님)와 장바구니 정보(임동진님)를 받아 결제를 진행하는 로직
    
    - [ ] 상품 재고를 주문 개수만큼 감소
    
  - Optional
  
    - [ ] 회원의 잔고에서 상품 가치만큼 감소

## DataBase : H2 (Temporary)



### Table : product 

`TABLE`

```sql
DROP TABLE IF EXISTS product;
 
CREATE TABLE IF NOT EXISTS product(
 	id bigint(5) NOT NULL AUTO_INCREMENT, 
	name varchar(100) NOT NULL, 
	content varchar(255) NOT NULL,
    stock int(5) NOT NULL DEFAULT 0,
    price int(15) NOT NULL DEFAULT 0,
	regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 	PRIMARY KEY (id) 
);
```

`SAMPLE DATA`

```sql
INSERT INTO product (name, content, stock, price) VALUES ('TEST01', 'This is a test content 1', 5, 35000);
INSERT INTO product (name, content, stock, price) VALUES ('TEST02', 'This is a test content 2', 3, 140000);
INSERT INTO product (name, content, stock, price) VALUES ('TEST03', 'This is a test content 3', 1, 230000);

SELECT * FROM product;
```



