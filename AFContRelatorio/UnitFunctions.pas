unit UnitFunctions;

interface
  


implementation
 function Bissexto(ano:integer):boolean;
 begin
  if ano mod 400 = 0 then
    result := true
  else if (ano mod 4 = 0) and (ano mod 100 <> 0) then
    result := true
  else
    result := false;
end;


end.
