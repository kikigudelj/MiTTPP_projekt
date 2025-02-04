# MiTTPP Projekt

## Uvod

Ovaj dokument opisuje automatske testove napisane u Javi uz korištenje Selenium frameworka. Cilj testova je provjeriti ispravnost funkcionalnosti različitih web aplikacija, omogućujući bržu detekciju grešaka i poboljšanja softvera.

---

## Preduvjeti za pokretanje testova

Prije pokretanja testova potrebno je:

1. Instalirati **Java JDK**
2. Instalirati **IntelliJ IDEA** (ili drugo razvojno okruženje koje podržava Javu)
3. Preuzeti **Chrome Driver**
4. Dodati putanju do **chromedriver.exe** u sistemsku varijablu okruženja
5. Instalirati **Maven** za upravljanje ovisnostima

---

## Struktura projekta i postupak izvršavanja testova

Projekt je organiziran u sljedećim direktorijima:

- `src/main/java` – Glavni kod aplikacije
- `src/test/java` – Testni kod koji se sastoji od 5 file-ova, svaki predstavlja 1 test

Testove je moguće pokrenuti na dva načina:
1. Direktno unutar **IntelliJ IDEA** razvojnog okruženja 
2. Korištenjem komandne linije putem **Maven** alata:
   - `mvn test`

---

## Opis testova

### **1. ChessLoginTest**
**Svrha:** Verifikacija uspješne prijave na Chess.com s važećim korisničkim podacima.

**Opis:** 
- Otvara stranicu za prijavu na **Chess.com**
- Unosi korisničko ime i lozinku
- Simulira klik na dugme za prijavu
- Provjerava je li korisnik uspješno preusmjeren na početnu stranicu igre
- U slučaju neuspješne prijave, prikazuje poruku: *"Prijavljivanje nije uspjelo."*

---

### **2. FeritPageTest**
**Svrha:** Provjera navigacije do sekcije s informacijama o studijskim programima na web stranici **FERIT-a**.

**Opis:** 
- Otvara početnu stranicu **FERIT-a** i maksimizira preglednik
- Klikne na link *"Upisi i studiji"*, zatim na *"Pregled studijskih programa"*
- Korištenjem **WebDriverWait** osigurava da je stranica uspješno učitana
- Provjerava URL kako bi potvrdio uspješnu navigaciju

---

### **3. NikeAddToFavouritesTest**
**Svrha:** Omogućiti pretraživanje proizvoda na **Nike** web stranici i dodavanje u omiljene proizvode.

**Opis:** 
- Otvara stranicu s **Jordan** proizvodima na **Nike**
- Pokreće pretragu za *"Tech Fleece"*
- Klikne na prvi proizvod iz rezultata
- Simulira dodavanje proizvoda u favorite
- Provjerava preusmjerava li sustav korisnika na stranicu za prijavu

---

### **4. PlaytoyLoginTest**
**Svrha:** Verifikacija prijave na **Playtoy** platformu.

**Opis:** 
- Otvara stranicu za prijavu na **Playtoy**
- Unosi korisničko ime i lozinku
- Koristi **WebDriverWait** za osiguranje učitanja elemenata
- Provjerava preusmjerava li sustav korisnika na početnu stranicu **Playtoy-a**, čime potvrđuje uspješnu prijavu

---

### **5. ZalandoSearchTest**
**Svrha:** Provjera funkcionalnosti filtriranja proizvoda na **Zalando** web stranici.

**Opis:** 
- Otvara početnu stranicu **Zalando**
- Odabire kategoriju *"obuća"*
- Korištenjem filtera odabire proizvode brenda *"Adidas"*
- Provjerava jesu li svi koraci pravilno izvršeni i je li filtriranje uspješno

---

## Zaključak

Implementirani testovi omogućuju pouzdano testiranje ključnih funkcionalnosti različitih web aplikacija, smanjujući potrebu za ručnim testiranjem i poboljšavajući efikasnost softverskog razvoja. Integracijom Selenium frameworka i TestNG biblioteke, osigurana je fleksibilnost, skalabilnost i preciznost u provjeri ispravnosti aplikacija.

Za dodatne informacije ili proširenja testnih scenarija, slobodno se obratite.

---

**Autor:** Kristijan Gudelj  


