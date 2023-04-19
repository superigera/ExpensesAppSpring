insert into members(lastName,firstName,email,password)values
('鈴木', '健太1', 'test1@test.co.jp', 'testpass'),
('鈴木', '健太2', 'test2@test.co.jp', 'testpass'),
('鈴木', '健太3', 'test3@test.co.jp', 'testpass');


insert into categories(categoryName, categoryFlag)values
('給与', '0'),
('ボーナス', '0'),
('その他収入', '0'),
('食費', '1'),
('外食費', '1'),
('日用品', '1'),
('衣服', '1'),
('交通費', '1'),
('水道光熱費', '1'),
('その他支出', '1');


insert into records(dating, amountOfMoney, categoryId, remarks,created_at)values
('2023-03-12', 1000, 1, '備考欄', CURRENT_TIMESTAMP),
('2023-03-13', 2000, 0, '備考欄', CURRENT_TIMESTAMP),
('2023-03-11', 3000, 1, '備考欄', CURRENT_TIMESTAMP),
('2023-03-12', 4000, 2, '備考欄', CURRENT_TIMESTAMP),
('2023-03-13', 5000, 4, '備考欄', CURRENT_TIMESTAMP),
('2023-03-14', 6000, 5, '備考欄', CURRENT_TIMESTAMP);
