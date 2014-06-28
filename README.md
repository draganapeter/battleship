battleship
==========

Battleship, tj Potapanje brodova je već odavno poznata igrica, koja primjenu nalazi i u nekim verzijama programa Skype. 
Može se reći da je to sa programerske strane slojevita igrica,koja zahtjeva pažljivo razmišljanje "šta je od čega straije".
Za igranje, ova igrica nije teška, zadržava pažnju igrača, u ovoj verziji je obrađena samo opcija kada igrač igra protiv 
kompjutera, ali postoje i verzije kada dva igrača igraju jedan protiv drugog.

Naime, igra se sastoji u tome da igrač najprije označi polja (njih 10 u ovo slučaju) i na taj način "postavi brodove na njih".
Zatim počinje igra. Kompjuter random gađa polja igračeve table, i igrač i kompjuter gađaju naizmjenično. Ko prvi pogodi
svih 10 polja na kojima su brodovi, odnosno "potopi sve brodove", taj je pobjedio.

Igra sadrži klase:
- Potapanjebrodova1, 
- Board, 
- Frame,
- Objects,
- Polje i
- Tabla

Klasa Potapanjebrodova1 sadrži metodu main. Klasa koja sadrži metodu main je start programa.

Klasa Board nasljeđuje klasu JPanel,koja predstavlja (možemo reči) kontejner za grupisanje skupa komponenata. Ova klasa 
sadrži atribute: širinu panela, dužinu panela, korištene slike, poruke,boju pozadine..i objekte klasa Tabla i Polje.
Podrazumjevani konstruktor postavlja veličinu table,pozadinu, inicijalizuje objekte u igri...kao i dugme za početak igre
(JButton).Metoda paint služi za iscrtavanje, možemo reći da je malo komplikovanija,iz razloga što se u različitim stanjima
igre iscrtavaju različiti objekti(u postavljanju brodova iscrtava se samo igračeva tabla, dugme za početak koje "sluša"
ActionListener tek kad se postavi svih 10 brodova, i poruka i broju brodova koje još treba postaviti). Metoda PocniIgru
prikazuje dugme dok program nije "u igri" i dok traje postavljanje brodova. Metoda HitListener govori poljima kako da se
ponašaju uz određene uslove kada se mišem kline na njih.

Klasa Frame nasljeđuje klasu JFrame, i u njoj pravimo Meni igrice.

Klasa Polje, možemo reći, predstavlja jedan objekat polje tabli na kojima se igra. Svako polje može da ima neko od stanja: 
- da na njemu ima ili nema brod,
- da je brod postavljen ili ne (u slučaju igračeve table)
- i da je to polje gadjano ili da nije gadjano.
Upravo zato imamo boolean za sva tri ova stanja.U konstruktoru Polje postavljamo veličinu polja, i stanja na negadjana.
U Metodi Gadjaj stanje polja prelazi na gadjano pozivom te metode. Metodom draw iscrtavamo polja, bojama u zavisnosti
od stanja koja oni poprimaju.

Klasa Java nasljeđuje klasu JPanel. Svaka tabla se sastoji od matrice polja 10x10, dnosno od 10 redova nizova polja.
U konstruktoru postavljamo broj redova i vrsta table,tj broj polja, i takođe određujemo koordinate polja u prvom redu
i prvoj vrsti matrice,tj table. Na osnovu tih koordinata iscratava se kasnije čitava tabla. Metoda ProvjeraZaGadjanje
"kupi" koordinate tačke na koju je kliknuto mišem, provjerava da li se ona anlazi u valjanom polju,i možemo reći 
da nakon provjere dozvoljava gadjanje. takodje u ovoj metodi,bollean-om je spriječeno da se klik na pogrešna mjesta
vodi kao radnja gađanja. Metoda prebrojavanjeBrodova prolazi kroz polja table i broji koliko polja je u stanju da imaBrod
Metoda prebrojavanjePotopljenih je slična metodi prebrojavanjeBrodova samo što ona u suštini broji ona polja koja imaju
i stanje da imaju brod, i stanje da su gadjana.Metodom PostaviBrod uzmaju se koordinate tačke klika i ono polje igraceve 
table koje sadrži te koordinate, mu se mjenja stanje da ima brod. Metoda postavljanje Brodova ustvari random rasporedjuje
10 brodova na kompjuterovu tablu tako što iz niza polja pravi skup od 10 elemenata,iz razloga sto se u skupu ne mogu
ponavljati elementi, pa je time spriječeno da se dva ili više brodova rasporede na isto polje. u metodi GadjanjeKomp je
na sličan način formiran odabir random polja što ustvari predstavlja random gadjanje kmpjutera. Tablu iscrtavamo tako sto 
se iscrta 10 redova po 10 polja. to se radi metodom draw.
