--Company
CREATE TABLE Company (id bigint NOT NULL auto_increment, name varchar(255), item varchar(150));
INSERT INTO Company (name, item) VALUES ('Compu Mundo', 'computacion');

--Clients
CREATE TABLE Clients (id bigint NOT NULL auto_increment, name varchar(150) NOT NULL, last_name VARCHAR(150), email VARCHAR(255), dni int NOT NULL, phone bigint, PRIMARY KEY (id));
INSERT INTO Clients (name, last_name, email, dni, phone) VALUES ('Sumo', 'Alvo', 'gordo@gmail.com', 23498999, 4271992);
INSERT INTO Clients (name, last_name, email, dni, phone) VALUES ('Arenita', 'Rodriguez', 'arenita@gmail.com', 34506876, 2215647878);
INSERT INTO Clients (name, last_name, email, dni, phone) VALUES ('Alejandra', 'Perez', 'ale@gmail.com', 18203400, 2213845645);
INSERT INTO Clients (name, last_name, email, dni, phone) VALUES ('Daniel', 'Lopez', 'daniel@gmail.com', 32888463, 2213424590);
INSERT INTO Clients (name, last_name, email, dni, phone) VALUES ('Patricio', 'Garcia', 'pato@gmail.com', 22143287, 4830999);

--Categories
CREATE TABLE Categories(id bigint NOT NULL auto_increment, name VARCHAR(150) NOT NULL, PRIMARY KEY(id));
INSERT INTO Categories(name) VALUES ('perifericos');
INSERT INTO Categories(name) VALUES ('componentes');
INSERT INTO Categories(name) VALUES ('monitores');
INSERT INTO Categories(name) VALUES ('computadoras');


--Products
CREATE TABLE Products(id bigint NOT NULL auto_increment, name VARCHAR(150) NOT NULL, stock int NOT NULL, price numeric, detail varchar(500), category_Id bigint, FOREIGN KEY(category_Id) REFERENCES Categories(id), PRIMARY KEY(id));
INSERT INTO Products(name, stock, price, detail, category_id) VALUES ('Mouse Logitech', 24, 450, 'Inalambrico', 1);
INSERT INTO Products(name, stock, price, detail, category_id) VALUES ('Notebook Asus 10', 8, 109450, 'SDD 256, 8 RAM', 4);
INSERT INTO Products(name, stock, price, detail, category_id) VALUES ('Teclado Ducky', 2, 12450, 'Switch box-withe', 1);
INSERT INTO Products(name, stock, price, detail, category_id) VALUES ('Auriculares', 6, 10800, 'Inalambrico', 1);
INSERT INTO Products(name, stock, price, detail, category_id) VALUES ('Web Cam', 3, 8000, 'FULL HD', 1);
INSERT INTO Products(name, stock, price, detail, category_id) VALUES ('Ram', 36, 7450, '8 GB DDR4', 2);
INSERT INTO Products(name, stock, price, detail, category_id) VALUES ('Mother MSI Tomahawk', 17, 35600, 'Socket 1200', 2);
INSERT INTO Products(name, stock, price, detail, category_id) VALUES ('Fan Id-cooling', 25, 1999, '120mm, 1800rpm', 2);
INSERT INTO Products(name, stock, price, detail, category_id) VALUES ('Water Cooling Cooler Master', 28, 13799, 'Intel/AMD 240mm', 2);
INSERT INTO Products(name, stock, price, detail, category_id) VALUES ('Cpu Cooler Hyper 212', 20, 8345, 'Intel/AMD', 2);

--Details
CREATE TABLE Details(id bigint NOT NULL auto_increment, product_id bigint, quantity int, parcial_price numeric, FOREIGN KEY(product_id) REFERENCES Products(id));
INSERT INTO Details(product_id, quantity, parcial_price) VALUES (3, 1, 450);

--Invoices
CREATE TABLE Invoices(id bigint NOT NULL auto_increment, date DATE, client_id bigint, detail_id bigint, company_id bigint, FOREIGN KEY(client_id) REFERENCES Clients(id), FOREIGN KEY(detail_id) REFERENCES Details(id), FOREIGN KEY(company_id) REFERENCES Company(id));
