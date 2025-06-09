# 🌍 KAOW - Keep Attention on the World 🚨

**KAOW** é um sistema completo de monitoramento e relato de desastres naturais, promovendo informação e segurança em tempo real. A plataforma combina um app mobile (React Native), backend robusto (Spring Boot + Oracle DB) e uma documentação completa via Swagger/OpenAPI.

## 📱 Aplicação Mobile
Desenvolvida com **React Native**, a aplicação permite que qualquer usuário:
- Poste relatos de desastres (alagamentos, incêndios, etc)
- Visualize outras postagens geolocalizadas
- Comente em postagens
- Curta relatos
- Acesse seu perfil e altere informações

## 🚀 Backend (Spring Boot)
API REST com segurança JWT, conexão com banco Oracle e uso de boas práticas como:
- DTOs separados para Request/Response
- Mapeamento com `@Entity`
- Serviços com lógica encapsulada
- Validações com Bean Validation
- Paginação, ordenação e filtros
- Documentação com Swagger OpenAPI

### Principais Funcionalidades
- **Login e Autenticação JWT**
- **CRUD completo de Postagens**
- **Curtir e Descurtir postagens**
- **Comentários vinculados a usuários**
- **Atualização de perfil do usuário**
- **Relacionamentos entre entidades (Postagem, Usuário, Endereço, Desastre, Nível de Perigo, Resolução)**

## 🔐 Segurança
- Autenticação via JWT
- Filtro `JwtAuthenticationFilter` customizado
- CORS configurado para produção

## 🌐 API Documentation (Swagger)
Feita no Swagger, arquivo yaml enviado, somente colar ao acessar esse link: https://editor.swagger.io/

## 🛠️ Tecnologias Utilizadas
- **Frontend:** React Native + TypeScript
- **Backend:** Java 17 + Spring Boot + Spring Security + JWT
- **Banco de Dados:** Oracle
- **Documentação:** Swagger OpenAPI 3.0.3
- **Deploy:** Render (Java API hospedada)

## 👨‍💻 Participantes
Thiago Mendes: 		RM 555352

Guilherme Gonçalves: 	RM 558475

Vinicius Banciela: 	RM 558117

---
Link do vídeo: [LINK]

Com KAOW, você está sempre por dentro dos acontecimentos 🌪️🔥🌊
