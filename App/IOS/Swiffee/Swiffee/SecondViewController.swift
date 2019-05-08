//
//  SecondViewController.swift
//  Swiffee
//
//  Created by Laksh Bhambhani on 4/30/19.
//  Copyright © 2019 Laksh Bhambhani. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController {
    let textField = UITextView()
    let run = UIButton()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.view.addSubview(textField)
        self.view.addSubview(run)
        
        textField.text = ""
        textField.textColor = UIColor.black
        textField.translatesAutoresizingMaskIntoConstraints = false
        textField.rightAnchor.constraint(equalTo: view.rightAnchor).isActive = true
        textField.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 16).isActive = true
        textField.topAnchor.constraint(equalTo: run.bottomAnchor, constant: 16).isActive = true
        textField.bottomAnchor.constraint(equalTo: view.bottomAnchor).isActive = true
        textField.heightAnchor.constraint(equalToConstant: 100).isActive = true
        textField.widthAnchor.constraint(equalToConstant: 100).isActive = true
        textField.heightAnchor.constraint(equalToConstant: 100).isActive = true
        
        
        run.setTitle("Run", for: .normal)
        run.setTitleColor(UIColor.blue, for: .normal)
        run.translatesAutoresizingMaskIntoConstraints = false
        run.rightAnchor.constraint(equalTo: view.rightAnchor).isActive = true
        run.leftAnchor.constraint(equalTo: view.leftAnchor).isActive = true
        run.topAnchor.constraint(equalTo: view.topAnchor, constant: 16).isActive = true
        run.bottomAnchor.constraint(equalTo: textField.topAnchor, constant: 8).isActive = true
        run.widthAnchor.constraint(equalToConstant: 100).isActive = true
        run.heightAnchor.constraint(equalToConstant: 20).isActive = true
    }


}

