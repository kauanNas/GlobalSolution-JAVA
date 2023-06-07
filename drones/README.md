# Observações sobre o projeto:

- Você pode rodá-lo com ele conectado no Mysql ou no oracle, apenas mude as configurações nas properties, de padrão está com o mysql(crie um database chamado drones), pois o meu oracle estava bugado

- As telas de gestão de drones estão funcionando, mas além da entrada e saida dos dados de telemetria serem feitas pelo insominia, as operações de 
iniciar voo e finalizar voo também são feitas por lá, gerando o histórico.

- As configurações de autenticação estão no código dentro do pacote infra e as roles nos respectivos controllers, entretanto estão comentados, pois estava bugando na hr de autenticar. 
