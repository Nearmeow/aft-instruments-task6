# language: ru

  @withdrawal
  Функция: Депозит

    @firstTest
    Сценарий: Проверка выдачи депозитов по заданным критериям
      Дано Клик на базовое меню - 'deposits'
      И Проверка открытия страницы 'Вклады'
      И Открытие настроек вкладов
      И Проверка открытия настроек вкладов
      И Заполнить поле значением - '1000000'
      И Кликнуть на выпадающее меню 'Срок'
      И Выбрать из списка значение - '6 месяцев'
      И Кликнуть на выпадающее меню 'Тип вклада'
      И Выбрать из списка значение - 'Обычные вклады'
      И Выбрать банки из списка
        | Открытие    |
        | Тинькофф    |
        | ВТБ         |
        | Газпромбанк |
        | Сбербанк    |
      И Отметить дополнительные чекбоксы
        | Со снятием       |
        | С пополнением    |
        | С капитализацией |
      И Нажать на кнопку поиска результатов
      И Проверить, что в списке содержится ожидаемое количество вкладов - '14'
