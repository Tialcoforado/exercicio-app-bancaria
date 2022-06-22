/* Crie uma aplicação que simule uma app bancária. 

Os clientes podem ser pessoa física ou jurídica, 
sendo que para PJ existe a cobrança de uma taxa de 0.5% para cada saque ou transferência. 
Além do produto conta-corrente, os clientes PF podem abrir uma conta-poupança e conta-investimento. 
Clientes PJ não abrem poupança, mas seus rendimentos em conta-investimento rendem 2% a mais.

Crie as funcionalidades: abrir conta, sacar, depositar, transferência, investir, consultar saldo.

Use a classe "Aplicacao" para criar seu método "main" e demonstrar o funcionamento do seu código.
O projeto pode ser entregue via arquivo zip para o e-mail do professor ou via link de repositório Github.

*/



Quais os conteúdos que são utilizados para o projeto:

Criar classe cliente, super classe cliente e classes filhas cliente pf e cliente pj
Criar classe conta, super classe conta e classes filhas, conta poupança, conta investimento

Métodos do cliente:
    Abrir conta
    Depositar
    Sacar
    Transferir
    Investir
    Consultar Saldo

Métodos da conta:
    Especificar os rendimentos por tipo de conta (Sobrescrita do método do rendimento/investimento)