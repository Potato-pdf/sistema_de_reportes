TRUNCATE TABLE agentes RESTART IDENTITY CASCADE;

insert into 
  agentes (
    id, 
    activo, 
    apellido_materno, 
    apellido_paterno, 
    created_at, 
    email, 
    fecha_contratacion, 
    fecha_nacimiento, 
    nombre, 
    telefono, 
    territorio, 
    updated_at
  )
values
  (1, true, 'García', 'Pérez', NOW(), 'juan.perez@test.com', '2024-01-15', '1990-05-10', 'Juan', '5551234567', 'Norte', NOW()),
  (2, true, 'Martínez', 'López', NOW(), 'ana.lopez@test.com', '2023-03-20', '1985-08-22', 'Ana', '5559876543', 'Sur', NOW()),
  (3, true, 'Sánchez', 'Ramírez', NOW(), 'carlos.ramirez@test.com', '2022-07-01', '1992-12-01', 'Carlos', '5551112233', 'Centro', NOW()),
  (14, true, 'Alias14', 'Catorce14', NOW(), 'playcanada513+14@gmail.com', '2024-02-14', '1991-02-14', 'Agente14', '5550001014', 'Este14', NOW()),
  (15, true, 'Alias15', 'Quince15', NOW(), 'playcanada513+15@gmail.com', '2024-03-15', '1992-03-15', 'Agente15', '5550001015', 'Oeste15', NOW()),
  (16, true, 'Alias16', 'Dieciseis16', NOW(), 'playcanada513+16@gmail.com', '2024-04-16', '1993-04-16', 'Agente16', '5550001016', 'Norte16', NOW());

  SELECT id, email FROM agentes WHERE id = 16;