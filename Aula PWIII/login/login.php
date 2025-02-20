
<?php
require 'Contato.class.php';

$conecta = $contato = new Contato();

if( !$conecta ){
    echo "<h1>Erro ao conectar ao banco de dados</h1>";
    //exit;
}else{
    $usuario = $contato->chkUser("fabio.claret@gmail.com");
    if(!$usuario){
        $usuario = $contato->insertUser("Fabio Claret", "fabio.claret@gmail.com", "123456");
    }else{
        echo "Usuário já exite!";
    }
    

}
