# Black-Jack-Casino-Game

## 1. Opis funkcjonalności

<p align="justify"> „Black Jack” stanowi obiektową implementację popularnej gry kasynowej o tej samej nazwie.
Technologia, którą użyto w ramach implementacji opiera się na środowisku Java oraz JavaFX ,na
podstawie których zrealizowano wymagania obiektowości dotyczące abstrakcji, hermetyzacji,
dziedziczenia, polimorfizmu oraz innych funkcjonalności języka.
Zasady panujące w trakcie rozgrywki nieznacznie odbiegają od tych, które można spotkać w
turniejowych wersjach gry. Na potrzeby projektu zrezygnowano z funkcjonalności, które oferuje obecność
stawki, w tym podbijanie, gromadzenie oraz dynamiczna kalkulacja stanu konta gracza. Stół ograniczono
do jednego pola decyzji a wartość karty „As” automatycznie zmniejsza się z 11 do 1 w odniesieniu do
przebicia granicy wynoszącej 21.
Realizacja obiektowa Black Jack’a w pełni losowo dobiera karty spośród pełnej talii kart symulując
algorytm wykonywany przez krupiera. Każda, unikalna karta korzysta z danych o talii, które zgromadzone
są w formie pliku w formacie JSON.
Do dyspozycji gracza przeznaczony jest komplet kontrolek sterujących aktualnym stanem
rozgrywki, do których dostęp przydzielany jest sekwencyjnie. Korzystając z bogatego zasobu
funkcjonalności środowiska FX, zaimplementowano efekty wizualne będące elementem wiernego oddania
symulacji prawdziwej gry. </p>

## 2. Interface gracza oraz przebieg gry
<p align="center" width="100%">
    <img width="33%" src="https://user-images.githubusercontent.com/130700114/231870529-ca41f32b-738e-415b-90fe-1d33b1d71076.png">
</p>

<p align="justify"> Uruchomienie aplikacji powoduje wyświetlenie ekranu startowego zawierającego tytuł oraz responsywny przycisk PLAY. Ustawienie kursora w obszarze przycisku wyświetla jasną obwódkę, ustawienie kursora poza granice przycisku wygasza ją. </p>

<p align="center" width="100%">
    <img width="33%" src="https://user-images.githubusercontent.com/130700114/231870991-329f7868-233f-4b4a-8d4c-0c8a519c48df.png">
</p>

<p align="justify"> Następuje przełączenie zawartości ekranu na stoł do Black Jack’a. Gracz ma możliwość rozpoczęcia gry poprzez rozłożenie kart na stole przez wirtualnego krupiera (START), podbicia stawki (HIT) oraz passowania od dobierania (STAND). Licznik kart gracza (COUNTER) dynamicznie podpowiada graczowi w jakim stanie jest wartość jego kart.  </p>

<p align="center" width="100%">
    <img width="33%" src="https://user-images.githubusercontent.com/130700114/231871245-ffb37d92-0a22-4334-bbff-2681961e70e0.png">
</p>

<p align="center" width="100%">
    <img width="33%" src="https://user-images.githubusercontent.com/130700114/231871315-0d4efe0b-7a0a-4ab1-a6f2-b9bf79b33bd4.png">
</p>

<p align="justify"> W ramach decyzji gracza o podbiciu kartą, kolejna zostaje wylosowana i ustawiona w okolicy pola decyzyjnego. Następuje odkrycie drugiej karty krupiera, który musi dobierać jeśli wartość jego kart jest mniejsza niż 17. Od tej pory gracz nie może zmieniać stanu swojej kolekcji. Wirtualny krupier porównuje stan kart gracza oraz swoich, powiadamiając o wygranej jednego  z dwóch uczestników gry lub o nierozstrzygnięciu gry w przypadku identycznych wartości. </p>
