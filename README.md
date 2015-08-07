WSTÊP
---------------------
Program wpisuje dane do tabel bazy danych 'artistsandsongs' z podanych plików.
Na podstawie iloœci wprowadzonych artystów liczba albumów jest generowana losowo z przedzialu (1;5). Liczba utworów jest generowana na podstawie listy albumów, dla ka¿dego albumu losowana jest lista utworów z przedzia³u (1,10).

WYMAGANIA
---------------------
Python 2.7

- Aby sprawdziæ aktualn¹ wersjê Pythona w lini poleceñ nale¿y wpisac komendê 'python'

KONFIGURACJA
---------------------
- Aby wywo³aæ funkcje generuj¹c¹ dane nale¿y w lini poleceñ wpisaæ komendê:
	'python -c "import main; print main.generate(x)" ',
	gdzie x oznacza iloœæ wprowadzonych artystów.
	x musi byæ liczb¹ naturaln¹.
	
- Program prosi o podanie œcie¿ki do folderu zwieraj¹cego wprowadzane dane.
	W wypadku nie podania œcie¿ki adres folderu ustalany jest automatycznie.
	Domyœlny adres folderu z danymi to 'C:/Users/Praktyki/Desktop/InputData'.

- Aby móc uruchomiæ program z lini poleceñ nale¿y do zmiennej systemowej PATH dodac polecenie 'C:\Python27\;'
	Aby to wykonaæ nale¿y otworzyæ karte 'Zmienne systemowe':
		Komputer -> W³aœciwoœci -> Zaawansowane ustawienia systemu -> Zmienne œrodowiskowe -> Zmienne systemowe -> Path
	



