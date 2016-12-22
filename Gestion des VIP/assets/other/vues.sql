CREATE VIEW infovip AS SELECT
  vip.prenom as Prénom,
  vip.nom as Nom,
  CONCAT(UCASE(LEFT(type.nom, 1)),SUBSTRING(type.nom, 2)) as Type,
  CONCAT(UCASE(LEFT(nationalite.nom, 1)),SUBSTRING(nationalite.nom, 2)) as Nationalite,
  vip.importance as Importance
  FROM vip inner join type on vip.id_type=type.id INNER JOIN nationalite on vip.id_nationalite=nationalite.id;
