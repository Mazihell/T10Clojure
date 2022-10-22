;Aluno: Anderson Alves dos Santos

;1. Na  aula  disponível  em:  https://replit.com/@frankalcantara/ClojureAula2?v=1  f
;oram destacadas diversas funções (expressões), como funções de primeira ordem, 
;disponíveis em Clojure.  Sua  primeira  tarefa  será  descrever  cada  uma  destas  
;funções  e  apresentar  dois exemplos  de  uso  de  cada  uma  delas.  Lembre-se  os  
;exemplos  precisam  ser  utilizados  de forma que o resutado da função possa ser visto no terminal.   


;2. Utilizando a linguagem Clojure, crie uma função chamada ehPrimo 
;que receba um inteiro e devolva True caso este inteiro seja verdadeiro e False caso contrário. 

(defn verifica-divisao  
    [valor, valorL, contador]
    (cond
    (> contador valor) valorL
    (=(mod valor contador) 0) 
        (verifica-divisao valor 
            (conj valorL contador) (+ contador 1))
    :else (verifica-divisao valor valorL (+ contador 1)))
  )

(defn ehPrimo  
    [v]  
    (=(count (verifica-divisao v '() 1)) 2) )

(println "Exerc2 - Entrada: 4 Saida: " (ehPrimo 4))
(println "Exerc2 - Entrada: 3 Saida: " (ehPrimo 3))

;3. Utilizando  a  linguagem  Clojure,  crie  uma  função  chamada  
;fatoresPrimos  que  receba  um inteiro e devolva uma lista dos seus 
;fatores primos. Decomposição em fatores primos é uma tarefa fundamental da aritmética.  

(defn verifica-fatores  [v, valores,  valoresL]  
  (cond
    (=(count valores)0) valoresL
    (ehPrimo (first valores)) 
        (verifica-fatores v 
            (pop valores) 
                (conj valoresL (first valores)))
    :else (verifica-fatores v (pop valores) valoresL)
  )
)

(defn fatoresPrimos  
    [valores]
    (verifica-fatores valores 
        (verifica-divisao valores '() 1) '())
)
(println "Exerc3 - Entrada: 300 - Saida: " (fatoresPrimos 300))

;4. Utilizando  a  linguagem  Clojure,  crie  uma  função  chamada  todosPrimos  
;que  receba  dois valores inteiros e devolve todos os números 
;primos que existam entre estes dois valores.
