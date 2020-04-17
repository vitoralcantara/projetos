const express = require('express')
const bodyParser = require('body-parser')
const app = express()

var mongodb = require("mongodb")
var ObjectId = mongodb.ObjectID

const MongoClient = require('mongodb').MongoClient;

const uri = "mongodb+srv://dbUser:M1r4550l@cluster0-ebki5.mongodb.net/test?retryWrites=true&w=majority"

MongoClient.connect(uri,(err,client) => {
    if(err) return console.log(err)
    db = client.db('test') //coloque o nome do seu DB
    app.listen(3000, function(){
        console.log("server running on port 3000")
    })
})

app.use(bodyParser.urlencoded({extended:true}))

app.set('view engine','ejs')

app.get('/', (req, res) => {
    res.render('index.ejs')
})

app.get('/',(req,res) => {
    var cursor = db.collection('data').find()
})

app.get('/show',(req,res)=>{
    db.collection('data').find().toArray((err,results) => {
        if(err) return console.log(err)
        res.render('show.ejs',{
            data : results
        })
    })
})

app.post('/show', (req,res)=>{
    db.collection('data').save(req.body,(err,result) => {
        if (err) return console.log(err)

        console.log('salvo no banco de dados')
        res.redirect('/')
    })
})

app.route('/edit/:id').get((req,res) => {
  var id = req.params.id

  db.collection('data').find(ObjectId(id)).toArray((err,result) => {
      if(err) return res.send(err)  
      res.render('edit.ejs',{data:result})
      console.log(result)
  })
})
.post((req,res) => {
    var id = req.params.id
    var name = req.body.name
    var surname = req.body.surname

    db.collection('data').updateOne({_id: ObjectId(id)},{
        $set:{
            name:name,
            surname:surname
        }
    },(err,result) => {
        if(err) return res.send(err)
        res.redirect('/show')
        console.log('Atualizado no Banco de Dados')
    })
})