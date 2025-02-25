# MoscowZoo Мини дз КПО
Тут реализовано консольное приложение позваляющее
- добавить животных или предметы в зоопарк
- вывести животных в зоопарке
- вывести сумарное потребление килограммов еды в день
- вывести животных которые могут быть отправленны в контактный зоопарк

установка
1. Клонируйте репозиторий и установите зависимости:
   ```bash
   git clone https://github.com/toxabrat/MoscowZoo.git
   cd MoscowZoo
   mvn install
   ```
2. Для запуска запустите проект в IntelliJ IDEA
3. Для запуска тестов
   ```bash
   mvn test
   ```
4. Для просмотра тестового покрытия
   ```bash
   mvn clean verify
   ```
   само покрытие можно посмотрев открыв файл
   ```bash
   ~/target/site/jacoco-resources/jacoco-sessions.html
   ```
   или же это можно удобно посмотреть через IntelliJ IDEA

в коде есть следующие сущности: 
Zoo - сам зоопарк там храниться информация о животных он ассоциирован с
VetService, EntrAnimal, EntrThing, их можно подменить с помошью DI.
В animals лежат классы отвечающие за животных, в things - за вещи.
В properties.zoo.objects лежат интерфейсы которыми могут обладать обьекты зоопарка,
В entry - классы для добавления новых сущностей в зоопарк
DI реализован с помошью анотаций и SpringBoot

принципы SOLID:

Single Responsibility Principle 
- VetService отвечает только за прием животных
- Zoo отвечает только за хранение обьектов зоопарка и возможность передать нужному классу добавление новых обьектов
- Input отвечает только за считывание данных
- drawable.objects отвечают только за вывод определенной информации на экран 
- entry отвечают только за добавление новых обьектов

OpenClosedPrinciple 
- все классы имеют только приватные поля которые могут быть изменины и получены
с помошью какие то методов класса, getterов и seterов, так же от всех классов
не считая статичных можно отнаследоваться и дополнить их

Liskov substitution Principle
- вместо Animal можно подставить Herbo и Predator и любые другие классы животных аналогично с вещами
- все интерфесы могут быть реализованны и использованны любым из классов реализующих их

Interface Segregation Principle
- каждый интерфейс обладает одним методом и реализуеться только при необходимости

Dependency Inversion Principle
- Zoo не зависит от VetService и entry классов он завсит только от их абстракций 

**Анекдот**

Купили два брата грузина две лошади, отводят в стойло и думают: как различать, кто чей. 

Говорит старший брат:"Давай я своему ухо отрежу. У тебя будет двухухий конь, а у меня одноухий". Так и сделали, но завистливый сосед подслушал их разговор и ночью выкрался в стойло и отрезал второму коню ухо. 

Приходят два брата на утро и видят двух одноухих коней. Думают, как теперь их различать. Говорит старший брат:"Давай я своему ухо отрежу. У тебя будет одноухий конь, а у меня безухий". Так и сделали, но завистливый сосед снова подслушал их разговор и ночью выкрался в стойло и отрезал второму коню ухо. 

Приходят два брата на утро и видят двух одноухих коней. Думают, как теперь их различать. Говорит старший брат:"Давай я своему ухо отрежу. У тебя будет одноухий конь, а у меня безухий". Так и сделали, но завистливый сосед снова подслушал их разговор и ночью выкрался в стойло и отрезал второму коню ухо. 

Приходят два брата на утро и видят двух безухих коней. Думают, как теперь их различать. Говорит старший брат:"Давай я своему хвост отрежу. У тебя будет конь, а у меня без хвоста". Так и сделали, но завистливый сосед опять подслушал их разговор и ночью выкрался в стойло и отрезал второму коню хвост. 

Приходят два брата на утро и видят двух безхвостых коней. Думают, как теперь их различать. Говорит младший брат:"Давай мой чёрный, а твой белый".
