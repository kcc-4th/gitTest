drop table review;
drop table menu;
drop table restaurant;

drop sequence restaurant_seq;
drop sequence menu_seq;
drop sequence review_seq;

create table restaurant (
        id number primary key,
        name varchar2(50),
        address varchar2(200),
        created_at timestamp default current_timestamp,
        updated_at timestamp default current_timestamp
);

create sequence restaurant_seq;

insert into restaurant values(restaurant_seq.nextval, '우래옥', '서울 중구 창경궁로 62-29', systimestamp, systimestamp);
insert into restaurant values(restaurant_seq.nextval, '부산식당', '서울 종로구 인사동11길 12', systimestamp, systimestamp);
insert into restaurant values(restaurant_seq.nextval, '청진옥', '서울 종로구 종로3길 32', systimestamp, systimestamp);

create table menu (
      id number primary key,
      name varchar2(50),
      price number,
      restaurant_id number REFERENCES restaurant(id) on delete cascade,
      created_at timestamp default current_timestamp,
      updated_at timestamp default current_timestamp
);

create sequence menu_seq;

insert into menu values(menu_seq.nextval, '불고기', 37000, 1, systimestamp, systimestamp);
insert into menu values(menu_seq.nextval, '평양냉면', 16500, 1, systimestamp, systimestamp);
insert into menu values(menu_seq.nextval, '비빔냉면', 16000, 1, systimestamp, systimestamp);
insert into menu values(menu_seq.nextval, '온면', 16000, 1, systimestamp, systimestamp);
insert into menu values(menu_seq.nextval, '김치말이냉면', 15000, 1, systimestamp, systimestamp);

insert into menu values(menu_seq.nextval, '생대구탕', 16000, 2, systimestamp, systimestamp);
insert into menu values(menu_seq.nextval, '생태탕', 16500, 2, systimestamp, systimestamp);
insert into menu values(menu_seq.nextval, '된장찌개', 12000, 2, systimestamp, systimestamp);
insert into menu values(menu_seq.nextval, '삼치구이', 13000, 2,systimestamp, systimestamp);
insert into menu values(menu_seq.nextval, '제육볶음', 21000, 2, systimestamp, systimestamp);

insert into menu values(menu_seq.nextval, '선지 해장국', 11000, 3, systimestamp, systimestamp);
insert into menu values(menu_seq.nextval, '안주전골', 28000, 3, systimestamp, systimestamp);
insert into menu values(menu_seq.nextval, '따구국', 32000, 3, systimestamp, systimestamp);
insert into menu values(menu_seq.nextval, '내장수육', 28000, 3, systimestamp, systimestamp);
insert into menu values(menu_seq.nextval, '양지수육', 50000, 3, systimestamp, systimestamp);

create table review (
        id number primary key,
        content varchar2(500),
        score number,
        restaurant_id number REFERENCES restaurant(id) on delete cascade,
        created_at timestamp default current_timestamp
);

create sequence review_seq;

insert into review values(review_seq.nextval, '맛있었습니다', 3.4, 1, systimestamp);
insert into review values(review_seq.nextval, '기가막히네요', 4.5, 1, systimestamp);
insert into review values(review_seq.nextval, '또 올거같습니다', 3.4, 1, systimestamp);
insert into review values(review_seq.nextval, '좋았어요', 3.1, 1, systimestamp);
insert into review values(review_seq.nextval, '최고의 맛', 4.9, 1, systimestamp);
insert into review values(review_seq.nextval, 'content1', 3.4, 1, systimestamp);
insert into review values(review_seq.nextval, 'content2', 4.5, 1, systimestamp);
insert into review values(review_seq.nextval, 'content3', 3.4, 1, systimestamp);
insert into review values(review_seq.nextval, 'content4', 3.1, 1, systimestamp);
insert into review values(review_seq.nextval, 'content5', 4.9, 1, systimestamp);
insert into review values(review_seq.nextval, 'content6', 3.4, 1, systimestamp);
insert into review values(review_seq.nextval, 'content7', 4.5, 1, systimestamp);
insert into review values(review_seq.nextval, 'content8', 3.4, 1, systimestamp);
insert into review values(review_seq.nextval, 'content9', 3.1, 1, systimestamp);
insert into review values(review_seq.nextval, 'content10', 4.9, 1, systimestamp);

insert into review values(review_seq.nextval, '살짝 아쉽습니다', 2.4, 2, systimestamp);
insert into review values(review_seq.nextval, '맛있었습니다', 3, 2, systimestamp);

insert into review values(review_seq.nextval, '지상 최고의 맛', 5.0, 3, systimestamp);
insert into review values(review_seq.nextval, '술이 술술 들어가네요', 4.9, 3, systimestamp);
insert into review values(review_seq.nextval, '맛있었습니다. 또올게용', 4.3, 3, systimestamp);
insert into review values(review_seq.nextval, '잘먹고 갑니다', 3.1, 3, systimestamp);

commit;






