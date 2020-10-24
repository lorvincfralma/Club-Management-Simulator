# Club-management-simulator

Assignement 1 Software Engineering UniPR

L’obiettivo è definire le classi del sistema software che dovrà gestire un circolo sportivo utilizzando
in modo appropriato le tecniche di ereditarietà e composizione.

Il circolo è definito da un insieme di persone e di attività.

Ogni persona è definita da: nome, cognome, indirizzo email (usato come login per l’accesso al
sistema) e password.

Le persone possono avere il ruolo di socio o amministratore. Un amministratore può eseguire anche
le operazioni del socio.

Le attività possono essere gare o corsi e sono entrambe descritte da un nome e dalle persone a loro
iscritte

I soci possono:
- iscriversi a gare e corsi
- cancellare l’iscrizione a gare e corsi

Gli amministratori, oltre ad eseguire le operazioni di socio possono:
- aggiungere e rimuovere soci e amministratori e modificare i loro dati
- aggiungere e rimuovere gare e corsi e modificare i loro dati

Definite le classi, bisognerà implementare una semplice simulazione (i.e., un metodo “main”) che:
1) crea un amministratore, alcuni soci e alcune attività;
2) l’amministratore aggiunge, rimuove e modifica dei soci;
3) il sistema sceglie un socio;
4) il socio si iscrive a una gara e a un corso e poi cancella l’iscrizione di una delle due attività;
5) Infine il sistema presenta le informazioni possedute da soci, amministratori e attività.
