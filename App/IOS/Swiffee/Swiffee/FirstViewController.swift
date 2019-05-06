//
//  FirstViewController.swift
//  Swiffee
//
//  Created by Laksh Bhambhani on 4/30/19.
//  Copyright © 2019 Laksh Bhambhani. All rights reserved.
//

import UIKit

class FirstViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let forward = UIButton()
        let stop = UIButton()
        let reverse = UIButton()
        let left = UIButton()
        let right = UIButton()
        let bow = UIButton()
        let bendBack = UIButton()
        let jumpUp = UIButton()
        let jumpBack = UIButton()
        let pushUp = UIButton()
        
        self.view.addSubview(forward)
        self.view.addSubview(stop)
        self.view.addSubview(reverse)
        self.view.addSubview(left)
        self.view.addSubview(right)
        self.view.addSubview(bow)
        self.view.addSubview(bendBack)
        self.view.addSubview(jumpUp)
        self.view.addSubview(jumpBack)
        self.view.addSubview(pushUp)

        
        forward.setTitle("Forward", for: .normal)
        forward.setTitleColor(UIColor.blue, for: .normal)
        forward.translatesAutoresizingMaskIntoConstraints = false
        forward.rightAnchor.constraint(equalTo: view.rightAnchor, constant: -80).isActive = true
        forward.topAnchor.constraint(equalTo: view.topAnchor).isActive = true
        forward.bottomAnchor.constraint(equalTo: view.centerYAnchor, constant: -8).isActive = true
        forward.widthAnchor.constraint(equalToConstant: 100).isActive = true
        forward.heightAnchor.constraint(equalToConstant: 20).isActive = true
        
        reverse.setTitle("Reverse", for: .normal)
        reverse.setTitleColor(UIColor.blue, for: .normal)
        reverse.translatesAutoresizingMaskIntoConstraints = false
        reverse.topAnchor.constraint(equalTo: forward.bottomAnchor, constant: 8).isActive = true
        reverse.rightAnchor.constraint(equalTo: view.rightAnchor, constant: -80).isActive = true
        reverse.bottomAnchor.constraint(equalTo: view.bottomAnchor, constant: -8).isActive = true
        reverse.widthAnchor.constraint(equalToConstant: 100).isActive = true
        reverse.heightAnchor.constraint(equalToConstant: 20).isActive = true
        
        stop.setTitle("Stop", for: .normal)
        stop.setTitleColor(UIColor.blue, for: .normal)
        stop.translatesAutoresizingMaskIntoConstraints = false
        stop.centerYAnchor.constraint(equalTo: view.centerYAnchor).isActive = true
        stop.rightAnchor.constraint(equalTo: view.rightAnchor, constant: -80).isActive = true
        stop.widthAnchor.constraint(equalToConstant: 100).isActive = true
        stop.heightAnchor.constraint(equalToConstant: 20).isActive = true

        left.setTitle("Left", for: .normal)
        left.setTitleColor(UIColor.blue, for: .normal)
        left.translatesAutoresizingMaskIntoConstraints = false
        left.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 8).isActive = true
        left.centerYAnchor.constraint(equalTo: view.centerYAnchor).isActive = true
        left.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/8).isActive = true
        left.heightAnchor.constraint(equalToConstant: 20).isActive = true
        
        right.setTitle("Right", for: .normal)
        right.setTitleColor(UIColor.blue, for: .normal)
        right.translatesAutoresizingMaskIntoConstraints = false
        right.leftAnchor.constraint(equalTo: left.rightAnchor, constant: 8).isActive = true
        right.centerYAnchor.constraint(equalTo: view.centerYAnchor).isActive = true
        right.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/8).isActive = true
        right.heightAnchor.constraint(equalToConstant: 20).isActive = true

        bow.setTitle("Bow", for: .normal)
        bow.setTitleColor(UIColor.blue, for: .normal)
        bow.translatesAutoresizingMaskIntoConstraints = false
        bow.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 8).isActive = true
        bow.bottomAnchor.constraint(equalTo: right.topAnchor, constant: -30).isActive = true
        bow.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/4).isActive = true
        bow.heightAnchor.constraint(equalToConstant: 20).isActive = true
        
        jumpUp.setTitle("Jump Up", for: .normal)
        jumpUp.setTitleColor(UIColor.blue, for: .normal)
        jumpUp.translatesAutoresizingMaskIntoConstraints = false
        jumpUp.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 8).isActive = true
        jumpUp.bottomAnchor.constraint(equalTo: bow.topAnchor, constant: -30).isActive = true
        jumpUp.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/4).isActive = true
        jumpUp.heightAnchor.constraint(equalToConstant: 20).isActive = true
        
        pushUp.setTitle("Push Up", for: .normal)
        pushUp.setTitleColor(UIColor.blue, for: .normal)
        pushUp.translatesAutoresizingMaskIntoConstraints = false
        pushUp.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 8).isActive = true
        pushUp.bottomAnchor.constraint(equalTo: jumpUp.topAnchor, constant: -30).isActive = true
        pushUp.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/4).isActive = true
        pushUp.heightAnchor.constraint(equalToConstant: 20).isActive = true
        
        bendBack.setTitle("Bend Back", for: .normal)
        bendBack.setTitleColor(UIColor.blue, for: .normal)
        bendBack.translatesAutoresizingMaskIntoConstraints = false
        bendBack.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 8).isActive = true
        bendBack.topAnchor.constraint(equalTo: right.bottomAnchor, constant: 20).isActive = true
        bendBack.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/4).isActive = true
        bendBack.heightAnchor.constraint(equalToConstant: 20).isActive = true

        jumpBack.setTitle("Jump Back", for: .normal)
        jumpBack.setTitleColor(UIColor.blue, for: .normal)
        jumpBack.translatesAutoresizingMaskIntoConstraints = false
        jumpBack.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 8).isActive = true
        jumpBack.topAnchor.constraint(equalTo: bendBack.bottomAnchor, constant: 30).isActive = true
        jumpBack.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/4).isActive = true
        jumpBack.heightAnchor.constraint(equalToConstant: 20).isActive = true
        
        

        
        
        

    }


}

