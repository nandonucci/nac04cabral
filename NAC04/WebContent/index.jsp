<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="css/meustyle.css">
  </head>

  <body>
    <section class="login">
      <form action="loginServlet" method="post" class="form-login">
        <legend>Login</legend>
        <fieldset class="field-form">
          <label for="">Nome</label>
          <input name="usuario-login" type="text" placeholder="Digite seu nome">
        </fieldset>
        <fieldset class="field-form">
          <label for="">Senha</label>
          <input name="usuario-senha" type="password" placeholder="Digite sua senha">
        </fieldset>
        <button class="btn-form" type="submit">Entrar</button>
      </form>
    </section>
  </body>

  </html>