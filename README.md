# 쇼핑몰 상품 관리  - 정두영

- `product-list.html` 
  - 상품 조회를 위한 페이지
  - 상품 테이블을 조회해 상품들을 조회
  - 상품 재고가 0이라면 품절 표시
  - ~~바로 구매하기 버튼~~
  - ***장바구니 담기 버튼 (임동진님)***
- `product-register.html` 
  - ~~관리자만 가능 ?~~
  - 상품 등록을 위한 페이지
  - 상품 정보를 입력한 후(Form) submit을 누르면 상품의 정보를 상품 테이블에 저장
  - `registerProduct.do`에게 상품을 등록하는 로직 (상품 정보와 ***현재 로그인한 회원정보***를 넘겨줌)
- `registerProduct.do` 
  - 상품 정보와 ***현재 로그인한 회원정보***를 받아 각각 테이블에 저장하는 로직
- `product-payment.html`
  - 장바구니에 담아 놓은 상품 ~~혹은 단일 상품~~을 구매하는 페이지
  - ***현재 로그인한 회원정보 (박기선님)*** 그리고 ***장바구니 정보(임동진님)***를 불러와 페이지에 띄움
  - 결제하기 버튼 `buyProduct.do` - ***회원정보(박기선님)***와 ***장바구니 정보(임동진님)***를 넘겨줌
- `buyProduct.do`
  - ***회원정보(박기선님)***와 ***장바구니 정보(임동진님)***를 받아 결제를 진행하는 로직
  - 상품 재고를 주문 개수만큼 감소
  - ~~회원의 잔고에서 상품 가치만큼 감소~~

## H2



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



