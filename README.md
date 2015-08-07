WSTÊP
---------------------
Program wpisuje dane do tabel bazy danych 'artistsandsongs' z podanych plików.<br />
Na podstawie iloœci wprowadzonych artystów liczba albumów jest generowana losowo z przedzialu (1;5).<br /> 
Liczba utworów jest generowana na podstawie listy albumów, dla ka¿dego albumu losowana jest lista utworów z przedzia³u (1,10).<br />
<br />
WYMAGANIA
---------------------
Python 2.7<br />
<br />
- Aby sprawdziæ aktualn¹ wersjê Pythona w lini poleceñ nale¿y wpisac komendê 'python'<br />

KONFIGURACJA
---------------------
- Aby wywo³aæ funkcje generuj¹c¹ dane nale¿y w lini poleceñ wpisaæ komendê:<br />
	'python -c "import main; print main.generate(x)" ',<br />
	gdzie x oznacza iloœæ wprowadzonych artystów.<br />
	x musi byæ liczb¹ naturaln¹.<br />
<br />
- Program prosi o podanie œcie¿ki do folderu zwieraj¹cego wprowadzane dane.<br />
	W wypadku nie podania œcie¿ki adres folderu ustalany jest automatycznie.<br />
	Domyœlny adres folderu z danymi to 'C:/Users/Praktyki/Desktop/InputData'.<br />
<br />
- Aby móc uruchomiæ program z lini poleceñ nale¿y do zmiennej systemowej PATH dodac polecenie 'C:\Python27\;'<br />
	Aby to wykonaæ nale¿y otworzyæ karte 'Zmienne systemowe':<br />
		Komputer -> W³aœciwoœci -> Zaawansowane ustawienia systemu -> Zmienne œrodowiskowe -> Zmienne systemowe -> Path<br />
	



