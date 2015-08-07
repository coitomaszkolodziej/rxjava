WST�P
---------------------
Program wpisuje dane do tabel bazy danych 'artistsandsongs' z podanych plik�w.<br />
Na podstawie ilo�ci wprowadzonych artyst�w liczba album�w jest generowana losowo z przedzialu (1;5).<br /> 
Liczba utwor�w jest generowana na podstawie listy album�w, dla ka�dego albumu losowana jest lista utwor�w z przedzia�u (1,10).<br />
<br />
WYMAGANIA
---------------------
Python 2.7<br />
<br />
- Aby sprawdzi� aktualn� wersj� Pythona w lini polece� nale�y wpisac komend� 'python'<br />

KONFIGURACJA
---------------------
- Aby wywo�a� funkcje generuj�c� dane nale�y w lini polece� wpisa� komend�:<br />
	'python -c "import main; print main.generate(x)" ',<br />
	gdzie x oznacza ilo�� wprowadzonych artyst�w.<br />
	x musi by� liczb� naturaln�.<br />
<br />
- Program prosi o podanie �cie�ki do folderu zwieraj�cego wprowadzane dane.<br />
	W wypadku nie podania �cie�ki adres folderu ustalany jest automatycznie.<br />
	Domy�lny adres folderu z danymi to 'C:/Users/Praktyki/Desktop/InputData'.<br />
<br />
- Aby m�c uruchomi� program z lini polece� nale�y do zmiennej systemowej PATH dodac polecenie 'C:\Python27\;'<br />
	Aby to wykona� nale�y otworzy� karte 'Zmienne systemowe':<br />
		Komputer -> W�a�ciwo�ci -> Zaawansowane ustawienia systemu -> Zmienne �rodowiskowe -> Zmienne systemowe -> Path<br />
	



