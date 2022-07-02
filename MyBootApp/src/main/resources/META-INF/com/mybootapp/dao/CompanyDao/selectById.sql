select
  company_id,
  company_name,
  regist_date,
  regist_user_id,
  update_date,
  update_user_id,
  version
from
  company
where
  company_id = /* companyId */1
