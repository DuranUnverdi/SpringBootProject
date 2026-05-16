# Spring Boot REST API (öğrenme projesi)

Spring Boot 3, Spring Data JPA, PostgreSQL ve Spring Security kullanan katmanlı bir REST örneği. Amaç; controller / service / repository ayrımı, DTO kullanımı, entity ilişkileri ve temel Spring özelliklerini denemek.

## Gereksinimler

- **Java 21**
- **PostgreSQL** (yerelde çalışan bir instance)
- **Maven** (projede `mvnw` ile de çalıştırılabilir)

## Yapılandırma

Ayarlar `src/main/resources/app.properties` içindedir. Uygulama giriş sınıfında `@PropertySource("classpath:app.properties")` ile yüklenir.

Önemli alanlar:

- `spring.datasource.url`, `username`, `password` — kendi ortamınıza göre düzenleyin.
- `spring.jpa.properties.hibernate.default_schema` — örnek şemada `student` kullanılıyor.
- `spring.jpa.hibernate.ddl-auto=update` — geliştirme için; üretimde farklı strateji tercih edin.

Veritabanı şifresini repoda düz metin tutmak yerine ortam değişkeni veya yerel override (ör. `application-local.properties` + `.gitignore`) kullanmanız önerilir.

## Çalıştırma

```bash
./mvnw spring-boot:run
```

Derleme:

```bash
./mvnw -q compile -DskipTests
```

Ana sınıf: `com.spring_rest_api.springcore.SpringCoreApplication`

## API dokümantasyonu (OpenAPI / Swagger UI)

Uygulama çalışırken (varsayılan port **8080**):

- **Swagger UI:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- **OpenAPI JSON:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

Sunucu adresi `app.properties` içindeki `openapi.server-url` ile Swagger’da “Servers” alanına yansır (farklı port veya proxy için değiştirin).

## Paket yapısı (özet)

| Paket | Rol |
|--------|-----|
| `controller` / `controller.impl` | REST arayüzü; `impl` sınıfları `@RestController` |
| `services` / `services.impl` | İş kuralları ve dönüşüm |
| `repository` | Spring Data JPA |
| `entities` | JPA entity |
| `dto` | API ve katmanlar arası transfer nesneleri |
| `exception`, `handler` | Özel istisnalar ve `GlobalExceptionHandler` |
| `config` | Örnek bean’ler, Spring Security zinciri ve OpenAPI tanımı |
| `scheduled` | `@Scheduled` örnekleri |

## REST uçları (önekler)

Tüm yollar proje içinde tanımlı `@RequestMapping` önekleriyle birleşir; tipik önek: **`/rest/api/...`**

- **Öğrenciler:** `/rest/api/students` — CRUD benzeri işlemler, `DtoStudentIU` ile kayıt (`@Valid`).
- **Müşteriler:** `/rest/api/customers` — tekil getirme (`/list/{id}`), liste (`/list`), kayıt (`/save`), güncelleme (`PUT /update/{id}`); GET/liste/güncelleme yanıtlarında `RootEntity` sarmalayıcısı kullanılır.
- **Ev:** `/rest/api/homes/{id}`
- **Departman / çalışan:** `/rest/api/employee/department/...`

Tam liste için `controller.impl` altındaki sınıflara bakın.

## Güvenlik

`AppConfig` içinde `SecurityFilterChain` tanımlıdır: şu an **tüm isteklere izin** (`permitAll`), CSRF kapalı. Bu bir öğrenme / geliştirme düzenidir; gerçek ortamda kimlik doğrulama ve yetkilendirme ayrı tasarlanmalıdır.

Projede **JWT** bağımlılığı veya JWT akışı yoktur; token tabanlı güvenlik eklenecekse ayrıca eklenmesi gerekir.

## Projede yer alan başlıklar

- REST controller’lar ve HTTP metotları
- Spring Data JPA (`JpaRepository`)
- DTO ve `BeanUtils` ile basit eşleme
- `jakarta.validation` (`@Valid` vb., ilgili uçlarda)
- Entity ilişkileri (`@OneToOne`, `@OneToMany` vb.)
- `@ControllerAdvice` ile merkezi hata işleme (`handler.GlobalExceptionHandler`)
- `@EnableScheduling` ve örnek zamanlanmış görev
- Spring Security (şu anki haliyle tüm uçlara açık yapılandırma)
- **OpenAPI 3** ve **Swagger UI** (springdoc-openapi)

## Test

`src/test/java` altında Spring Boot test iskeleti bulunur; `./mvnw test` ile çalıştırılabilir.
