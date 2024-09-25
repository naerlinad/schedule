# Приложение "Записная книжка"

## _Салют_ 🖖

Данный небольшой проект был выполнен в качестве решения задания, вынесенного на промежуточную аттестацию
по окончанию курса лекций, посвященного объектно-ориентированному программированию.

Проект представляет собой консольное приложение имитирующее функционал записной книжки или органайзера.
Приложение позволяет создавать и хранить заметки двух типов: Событие (Event) и Задача (Task).

При записи События в него указывается дата и время его начала, а также опционально дата и время его окончания.
Если указаны обе временные точки, тогда приложение само подсчитывает длительность события и показывает его
при выводе информации о нём.

При создании Задачи указывается конечная дата и время его выполнения,
так называемый deadline. При выводе информации о Задаче приложение подсчитывает количество времени оставшегося 
на её выполнение от текущего момента до конечной даты.

Приложение может выводить заметки за определенную дату,
либо все заметки подпадающие во временной промежуток между двумя введёнными датами.
Также оно способно вывести записи
на текущую, следующую либо предыдущую неделю.

После получения выведенного списка, пользователь получает возможность отсортировать список
в хронологическом порядке, либо по критерию Приоритета. Имеется возможность редактирования созданных заметок.

При написании данного учебного проекта был использован язык программирования Java.

![picture_of_coffee](pic.png)
