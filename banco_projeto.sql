create table usuario (
	user_id INT AUTO_INCREMENT,
    nome_completo VARCHAR(120) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY (user_id)
)


create table conta (
	acc_id INT AUTO_INCREMENT,
    user_id INT,
    login VARCHAR(80) NOT NULL UNIQUE,
    senha VARCHAR(80) NOT NULL,
    saldo FLOAT DEFAULT 0,
    PRIMARY KEY (acc_id),
    FOREIGN KEY (user_id) REFERENCES usuario (user_id)
)