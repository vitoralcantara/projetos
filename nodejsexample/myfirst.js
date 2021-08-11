import { createServer } from 'http';
import * as fs from 'fs';
import * as url from 'url';
import * as uc from 'upper-case';

createServer(function (req, res) {
  res.writeHead(200, { 'Content-Type': 'text/html' });
  res.write(uc.upperCase("Hello World!"));
  res.end();

  // Exemplo de abertura de página a partir da leitura da url
  // var q = url.parse(req.url, true);
  // var filename = "." + q.pathname;
  // fs.readFile(filename, function (err, data) {
  //   if (err) {
  //     res.writeHead(404, { 'Content-Type': 'text/html' });
  //     return res.end("404 Not Found");
  //   }
  //   res.writeHead(200, { 'Content-Type': 'text/html' });
  //   res.write(data);
  //   return res.end();
  //});

  // Exemplo de obtenção de informações da url
  // var adr = 'http://localhost:8080/default.htm?year=2017&month=february';
  // var q = url.parse(adr, true);
  // console.log(q.host); //returns 'localhost:8080'
  // console.log(q.pathname); //returns '/default.htm'
  // console.log(q.search); //returns '?year=2017&month=february'
  // var qdata = q.query; //returns an object: { year: 2017, month: 'february' }
  // console.log(qdata.month); //returns 'february'


  // Exemplos de leitura e escrita de arquivo nas linhas abaixo
  // fs.readFile('demofile1.html', function (err, data) {
  //   res.writeHead(200, { 'Content-Type': 'text/html' });
  //   res.write(data);
  //   return res.end();
  // });
  // fs.appendFile('mynewfile1.txt', 'Hello content!', function (err) {
  //   if (err) throw err;
  //   console.log(req.url);
  // });
  // fs.open('mynewfile2.txt', 'w', function (err, file) {
  //   if (err) throw err;
  //   console.log('Saved!');
  // });
  // fs.writeFile('mynewfile3.txt', 'Hello content!', function (err) {
  //   if (err) throw err;
  //   console.log('Saved!');
  // });
  // fs.unlink('mynewfile2.txt', function (err) {
  //   if (err) throw err;
  //   console.log('File deleted!');
  // });
  // fs.rename('mynewfile1.txt', 'myrenamedfile.txt', function (err) {
  //   if (err) throw err;
  //   console.log('File Renamed!');
  // });
}).listen(8080);