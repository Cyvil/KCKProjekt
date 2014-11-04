KCKProjekt
==========

Wizualizacja trasy na podstawie opisu

Opis Projektu
Celem projektu jest skonstruowanie agentów z kompetencją językową. Agent działa w środowisku realizując plan i tworzy opis językowy działań, który interpretuje inny agent.
 
Temat: Tworzenie wizualizacji trasy na podstawie opisu.
W eksperymencie bierze udział dwóch agentów Agent 1 oraz Agent2.
Agent 1 pokonuje trasę T (wygenerowaną automatycznie) i tworzy jej opis w języku polskim (proste zdania). Przekazuje informację na temat sukcesywnie pokonywanych fragmentów drogi i zaobserwowanych elemntów środowiska (landmarków) widzianych w pobliżu trasy.
 
Na podstawie opisu tekstowego, Agent 2 generuje wizualizację trasy (2D).
 
Dane
Środowisko, którym jest pusta plansza o ograniczonych wymiarach, na której generowana jest trasa.
Trasa T składa się z fragmentów, którymi są odcinki i łuki (lewe i prawe, ostre i łagodne). Odcinki i łuki tworzą drogę, łącząc punktu etapowe. Punkty etapowe leżą w stałej odległości od sąsiednich. Punkty etapowe mogą być przelotowe lub stanowić skrzyżowania. Na planszy w pobliżu fragmentów trasy wzgl. punktów etapowych znajdują się elementy środowiska (landmarki). Landmarki mają warianty, różniące się cechami (rozmiar, kolor, kształt).
Agent 1 pokonuje trasę generując opis trasy T, w którym odnotowane są elementy środowiska znajdujące się w jego zasięgu. Agent 1 nie posługuje się numerycznymi odległościami ani czasem lecz może używać określeń stron świata (8). Elementy trasy nie mają nazw własnych.
Opis ma postać zdań prostych. Wolno używać czasownikó1)w związanych z ruchem (np. idę, mijam itp.), słó2)w określających elementy środowiska. Agent 1 stosuje strategię opisu wyczerpującegotj zawierającego wszelką informację przydatną przy tworzeniu opisu.
Agent 2 interpretuje opis dostarczony przez Agenta 1 i odtwarza w postaci wizualizacji mapę trasy T, nanosząc odpowiednie ikony landmarków.
Zalecane parametry:
Trasa długości 15-20 elementów wszystkich rodzajó3)w (odcinki, różne łuki), punkt początkowy A i punkt końcowy B. Minimum 10 elementów4) środowiska (landmarkó5)
