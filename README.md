# SpringBootRestApi
Basic spring boot application.

## Request 
| Parameters | Description |
| ---------- | ----------- |
| id         | Long |
| name       | String |
| email      | String |
| dob        | LocalDate |
| age        | Integer |

### Sample Post Request
```jsx
{
   "name": "Mary",
   "email": "mary@gmail.com",
   "dob : LocalDate.of(2000, APRIL, 5)
}
Id will be added automatically and age will be calculated based on today's date.
```
### Sample delete request
{{baseUrl}}/api/v1/student/studentId

### Sample put request
{{baseUrl}}/api/v1/student/studentId?paramater=newValue&paramater=newValue
