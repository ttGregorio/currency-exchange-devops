Projeto utilizado como modelo para exemplificar a utilização do Jenkins para automatizar a geração de imagens validando os testes

Passo a passo para configurar o Jenkins utilizando Linux/Mac

1 - instale o java
sudo apt update
sudo apt-get install default-jre

2 - instale o git
sudo apt-get install git

3 - instale o maven
sudo apt install maven

4 - instale o docker
sudo apt install docker.io

5 - instale o jenkins
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list' 
sudo apt update
sudo apt install jenkins

6 - starte o jenkins
sudo systemctl start jenkins
sudo systemctl status jenkins

7 - libere o acesso externo
sudo ufw allow 8080
sudo ufw status
sudo ufw allow OpenSSH
sudo ufw enable
sudo ufw status

8 - Ao acessar pela primeira vez, será pedida a senha padrão. Ela se encontra neste arquivo
sudo vim /var/lib/jenkins/secrets/initialAdminPassword

9 - Configure os dados de acesso master do jenkins e a instalação de plugins. Para este exemplo selecione os padrões.

10 - Instale os plugins relacionados ao Docker no jenkins. Isso é feito no menu Gerenciar Jenkins, Gerenciar Plugins, aba Disponíveis

11 - Ainda no menu Gerenciar Jenkins, selecione Global Tool Configuration. Nele vá até maven e adicione um novo, definindo um nome e selecionando Instalar automaticamente. Faça o mesmo procedimento para Docker

12 - Em Manage Credentials, entre em Jenkins, Global credentials, e crie uma nova com seu nome e senha de acesso ao dockerhub. Dê também um nome e uma descrição a esse acesso. Nesse exemplo, usamos o nome dockerhub.

13 - Vá ao menu Novo job. Nele insira um name, selecione pipeline e dê ok.

14 - Insira uma descrição para este job, vá até Pipeline, selecione Pipeline from SCM, em CSM coloque git, e insira o endereço do repositório no campo seguinte. Para este modelo, utilizamos https://github.com/ttGregorio/currency-exchange-devops . Clique em salvar

14 - Rode-o