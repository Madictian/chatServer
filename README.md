# chatServer
Serveren allokere en thread hver gang en client skaber forbindelse til socket 509002 op til 500threads

i hver thread køres et runnable handler object med sin egen socket.

Da handleren representere en bruger til chatten skal de have et navn, handler classen vil bede om et navn indtil et
godkendeligt navn læses fra brugeren og derefter tilføjes til hasset names.

serveren giver et output til sin egen terminal med at en clien er blevet accepteret.

Derefter giver serveren besked til all andre clienter om at en ny bruger har sluttet sig til chatten.


Clienterne får dynamisk opdateringer fra serveren via en thread der bliver ved med at skrive input fra severen ud i sin egen terminal.

Derudover bedes de give et username hvis de ikke har et endnu, dette sendes til serveren og bliver til brugerens navn på den anden side.

Herfra kan alle chatten med live opdateringer da den seperate thread opdatere deres egen chat når det kommer opdateringer fra serveren fra de andre clienter.
